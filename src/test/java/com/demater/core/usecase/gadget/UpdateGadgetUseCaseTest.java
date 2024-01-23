package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetMB;
import com.demater.builder.GadgetTypeMB;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetUpdatingEvent;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.UUID;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class UpdateGadgetUseCaseTest {
    @Mock
    private GadgetTypeRepository gadgetTypeRepository;
    @Mock
    private GadgetRepository gadgetRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private UpdateGadgetUseCase updateGadgetUseCase;

    @BeforeEach
    void setUp() {
        updateGadgetUseCase = new UpdateGadgetUseCase(gadgetTypeRepository, gadgetRepository, gadgetEventPublisher);
    }

    @Test
    void should_throw_when_update_gadget_with_gadget_dont_exists() {
        // Given
        UUID id = UUID.randomUUID();
        Gadget gadget = new GadgetMB().withId(id).withDesignation("aaa").build();
        when(gadgetRepository.findById(gadget.getId())).thenReturn(empty());

        // When
        Exception exception = assertThrows(GadgetNotFoundException.class, () -> updateGadgetUseCase.execute(id, gadget));

        // Then
        assertEquals("Gadget ID=[" + gadget.getId() + "] don't exists", exception.getMessage());
        verify(gadgetRepository).findById(gadget.getId());
        verify(gadgetRepository, never()).save(any(Gadget.class));
        verify(gadgetEventPublisher, never()).publishGadgetUpdatingEvent(new GadgetUpdatingEvent(gadget.getId()));
    }

    @Test
    void should_throw_when_update_gadget_with_gadget_new_designation_already_exists() {
        // Given
        UUID id = UUID.randomUUID();
        GadgetType type = new GadgetType(1L, "type 1");
        Gadget gadget = new GadgetMB().withId(id).withDesignation("bbb").withGadgetType(type).build();
        Gadget gadgetToUpdate = new GadgetMB().withId(id).withDesignation("aaa").build();
        when(gadgetTypeRepository.findById(type.getId())).thenReturn(of(type));
        when(gadgetRepository.existsByDesignationIgnoreCase(gadget.getDesignation())).thenReturn(true);
        when(gadgetRepository.findById(gadget.getId())).thenReturn(of(gadgetToUpdate));

        // When
        Exception exception = assertThrows(GadgetAlreadyExistsException.class, () -> updateGadgetUseCase.execute(id, gadget));

        // Then
        assertEquals("Gadget [" + gadget.getDesignation() + "] already exists", exception.getMessage());
        verify(gadgetRepository).findById(gadget.getId());
        verify(gadgetRepository).existsByDesignationIgnoreCase(gadget.getDesignation());
        verify(gadgetRepository, never()).save(any(Gadget.class));
        verify(gadgetEventPublisher, never()).publishGadgetUpdatingEvent(new GadgetUpdatingEvent(gadget.getId()));
    }

    @Test
    void should_update_gadget() {
        // Given
        UUID id = UUID.randomUUID();
        GadgetType gadgetType = new GadgetTypeMB().withId(1L).withDesignation("1").build();
        GadgetType gadgetTypeExisting = new GadgetTypeMB().withId(1L).withDesignation("1").build();
        Gadget gadget = new GadgetMB().withId(id).withDesignation("bbb").withGadgetType(gadgetType)
                .withAvailable(true).build();
        GadgetType gadgetTypeUpdate = new GadgetTypeMB().withId(2L).withDesignation("B").build();
        Gadget gadgetToUpdate = new GadgetMB().withId(id).withDesignation("aaa").withGadgetType(gadgetTypeUpdate)
                .withAvailable(false).build();
        when(gadgetRepository.existsByDesignationIgnoreCase(gadget.getDesignation())).thenReturn(false);
        when(gadgetTypeRepository.findById(gadgetType.getId())).thenReturn(of(gadgetTypeExisting));
        when(gadgetRepository.findById(gadget.getId())).thenReturn(of(gadgetToUpdate));
        Gadget gadgetToBeReturned = Gadget.builder().designation(gadget.getDesignation()).type(gadgetTypeExisting)
                .description(gadget.getDescription()).details(gadget.getDetails()).totalNumber(gadget.getTotalNumber())
                .remainingNumber(gadget.getRemainingNumber()).isAvailable(true).build();
        doReturn(gadgetToBeReturned).when(gadgetRepository).save(gadgetToUpdate);

        // When
        updateGadgetUseCase.execute(id, gadget);

        // Then
        verify(gadgetRepository).findById(gadget.getId());
        verify(gadgetRepository).existsByDesignationIgnoreCase(gadget.getDesignation());
        verify(gadgetTypeRepository).findById(gadgetType.getId());
        verify(gadgetToUpdate).update(
                gadget.getDesignation(),
                gadgetTypeExisting,
                gadget.getDescription(),
                gadget.getDetails(),
                gadget.getTotalNumber(),
                gadget.getRemainingNumber(),
                gadget.isAvailable()
        );
        verify(gadgetRepository).save(any(Gadget.class));
        verify(gadgetEventPublisher).publishGadgetUpdatingEvent(any());
    }
}
