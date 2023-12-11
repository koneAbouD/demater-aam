package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetTypeCreatingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetTypeAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class CreateGadgetTypeUseCaseTest {
    @Mock
    private GadgetTypeRepository gadgetTypeRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private CreateGadgetTypeUseCase createGadgetTypeUseCase;

    @BeforeEach
    void setUp() {
        createGadgetTypeUseCase = new CreateGadgetTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Test
    void should_throw_when_create_gadget_type_with_type_already_exists() {
        // Given
        String name = "type 1";
        when(gadgetTypeRepository.existsByDesignationIgnoreCase(name)).thenReturn(true);

        // When
        Exception exception = assertThrows(GadgetTypeAlreadyExistsException.class,
                () -> createGadgetTypeUseCase.execute(name));

        // Then
        assertEquals("Gadget type [" + name + "] already exists", exception.getMessage());
        verify(gadgetTypeRepository).existsByDesignationIgnoreCase(name);
        verify(gadgetTypeRepository, never()).save(any(GadgetType.class));
        verify(gadgetEventPublisher, never()).publishGadgetTypeCreatingEvent(new GadgetTypeCreatingEvent(name));
    }

    @Test
    void should_create_gadget_type() {
        // Given
        String name = "type 1";
        when(gadgetTypeRepository.existsByDesignationIgnoreCase(name)).thenReturn(false);

        // When
        createGadgetTypeUseCase.execute(name);

        // Then
        verify(gadgetTypeRepository).existsByDesignationIgnoreCase(name);
        ArgumentCaptor<GadgetType> captor = ArgumentCaptor.forClass(GadgetType.class);
        verify(gadgetTypeRepository).save(captor.capture());
        assertEquals(name, captor.getValue().getDesignation());
        verify(gadgetEventPublisher).publishGadgetTypeCreatingEvent(any());
    }
}
