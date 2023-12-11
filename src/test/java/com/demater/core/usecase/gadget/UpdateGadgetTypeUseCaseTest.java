package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetTypeMB;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetTypeUpdatingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class UpdateGadgetTypeUseCaseTest {
    @Mock
    private GadgetTypeRepository gadgetTypeRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private UpdateGadgetTypeUseCase updateGadgetTypeUseCase;

    @BeforeEach
    void setUp() {
        updateGadgetTypeUseCase = new UpdateGadgetTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Test
    void should_throw_when_update_gadget_type_with_gadget_type_dont_exists() {
        // Given
        GadgetType gadgetType = new GadgetTypeMB().withId(1L).build();
        when(gadgetTypeRepository.findById(gadgetType.getId())).thenReturn(empty());

        // When
        Exception exception = assertThrows(GadgetTypeNotFoundException.class,
                () -> updateGadgetTypeUseCase.execute(gadgetType));

        // Then
        assertEquals("Gadget type ID=[" + gadgetType.getId() + "] don't exists", exception.getMessage());
        verify(gadgetTypeRepository).findById(gadgetType.getId());
        verify(gadgetTypeRepository, never()).save(any(GadgetType.class));
        verify(gadgetEventPublisher, never()).publishGadgetTypeUpdatingEvent(
                new GadgetTypeUpdatingEvent(gadgetType.getDesignation()));
    }

    @Test
    void should_throw_when_update_gadget_type_with_gadget_type_designation_already_exists() {
        // Given
        GadgetType gadgetType = new GadgetTypeMB().withId(1L).withDesignation("new name").build();
        GadgetType gadgetTypeExisting = new GadgetTypeMB().withId(1L).withDesignation("last name").build();
        when(gadgetTypeRepository.findById(gadgetType.getId())).thenReturn(of(gadgetTypeExisting));
        when(gadgetTypeRepository.existsByDesignationIgnoreCase(gadgetType.getDesignation())).thenReturn(true);

        // When
        Exception exception = assertThrows(GadgetTypeAlreadyExistsException.class,
                () -> updateGadgetTypeUseCase.execute(gadgetType));

        // Then
        assertEquals("Gadget type ID [" + gadgetType.getDesignation() + "] already exists", exception.getMessage());
        verify(gadgetTypeRepository).findById(gadgetType.getId());
        verify(gadgetTypeRepository).existsByDesignationIgnoreCase(gadgetType.getDesignation());
        verify(gadgetTypeRepository, never()).save(any(GadgetType.class));
        verify(gadgetEventPublisher, never()).publishGadgetTypeUpdatingEvent(
                new GadgetTypeUpdatingEvent(gadgetType.getDesignation()));
    }

    @Test
    void should_update_gadget_type() {
        // Given
        GadgetType gadgetType = new GadgetTypeMB().withId(1L).withDesignation("new name").build();
        GadgetType gadgetTypeExisting = new GadgetTypeMB().withId(1L).withDesignation("last name").build();
        when(gadgetTypeRepository.findById(gadgetType.getId())).thenReturn(of(gadgetTypeExisting));
        when(gadgetTypeRepository.existsByDesignationIgnoreCase(gadgetType.getDesignation())).thenReturn(false);

        // When
        updateGadgetTypeUseCase.execute(gadgetType);

        // Then
        verify(gadgetTypeRepository).findById(gadgetType.getId());
        verify(gadgetTypeRepository).existsByDesignationIgnoreCase(gadgetType.getDesignation());
        verify(gadgetTypeExisting).update(gadgetType.getDesignation());
        ArgumentCaptor<GadgetType> captor = ArgumentCaptor.forClass(GadgetType.class);
        verify(gadgetTypeRepository).save(captor.capture());
    }
}
