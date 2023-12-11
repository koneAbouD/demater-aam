package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetMB;
import com.demater.builder.GadgetTypeMB;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetCreatingEvent;
import com.demater.core.port.GadgetRepository;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CreateGadgetUseCaseTest {
    @Mock
    private GadgetRepository gadgetRepository;
    @Mock
    private GadgetTypeRepository gadgetTypeRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private CreateGadgetUseCase createGadgetUseCase;

    @BeforeEach
    void setUp() {
        createGadgetUseCase = new CreateGadgetUseCase(gadgetRepository, gadgetTypeRepository, gadgetEventPublisher);
    }

    @Test
    void should_throw_when_create_gadget_with_gadget_designation_already_exists() {
        // Given
        Gadget gadget = new GadgetMB().withDesignation("aaa").build();
        when(gadgetRepository.existsByDesignationIgnoreCase(gadget.getDesignation())).thenReturn(true);

        // When
        Exception exception = assertThrows(GadgetAlreadyExistsException.class, () -> createGadgetUseCase.execute(gadget));

        // Then
        assertEquals("Gadget [" + gadget.getDesignation() + "] already exists", exception.getMessage());
        verify(gadgetRepository).existsByDesignationIgnoreCase(gadget.getDesignation());
        verify(gadgetRepository, never()).save(any(Gadget.class));
        verify(gadgetEventPublisher, never()).publishGadgetCreatingEvent(new GadgetCreatingEvent(gadget.getDesignation()));
    }

    @Test
    void should_create_gadget() {
        // Given
        UUID id = UUID.randomUUID();
        String designation = "aaa";
        Long gadgetTypeId = 1L;
        GadgetType gadgetType = new GadgetTypeMB().withId(gadgetTypeId).withDesignation("A").build();
        Gadget gadget = new GadgetMB().withDesignation(designation).withGadgetType(gadgetType).build();
        Gadget gadgetToSave = new GadgetMB().withId(id).withDesignation(designation).withGadgetType(gadgetType).build();
        when(gadgetRepository.existsByDesignationIgnoreCase(gadget.getDesignation())).thenReturn(false);
        when(gadgetTypeRepository.findById(gadgetTypeId)).thenReturn(Optional.of(gadgetType));
        when(gadgetRepository.save(any(Gadget.class))).thenReturn(gadgetToSave);

        // When
        createGadgetUseCase.execute(gadget);

        // Then
        verify(gadgetRepository).existsByDesignationIgnoreCase(gadget.getDesignation());
        verify(gadgetTypeRepository).findById(gadgetTypeId);
        verify(gadgetRepository).save(any(Gadget.class));
        verify(gadgetEventPublisher).publishGadgetCreatingEvent(any());
    }
}
