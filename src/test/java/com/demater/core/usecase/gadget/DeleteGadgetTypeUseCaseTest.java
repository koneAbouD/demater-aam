package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetTypeMB;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.event.gadget.GadgetTypeDeletingEvent;
import com.demater.core.port.GadgetTypeRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.gadget.exception.GadgetTypeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
class DeleteGadgetTypeUseCaseTest {
    @Mock
    private GadgetTypeRepository gadgetTypeRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private DeleteGadgetTypeUseCase deleteGadgetTypeUseCase;

    @BeforeEach
    void setUp() {
        deleteGadgetTypeUseCase = new DeleteGadgetTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }

    @Test
    void should_throw_when_delete_gadget_type_with_gadget_type_dont_exists() {
        // Given
        Long id = 1L;
        when(gadgetTypeRepository.findById(id)).thenReturn(empty());

        // When
        Exception exception = assertThrows(GadgetTypeNotFoundException.class, () -> deleteGadgetTypeUseCase.execute(id));

        // Then
        assertEquals("Gadget type ID=[" + id + "] don't exists", exception.getMessage());
        verify(gadgetTypeRepository).findById(id);
        verify(gadgetTypeRepository, never()).delete(any(GadgetType.class));
        verify(gadgetEventPublisher, never()).publishGadgetTypeDeletingEvent(new GadgetTypeDeletingEvent(id));
    }

    @Test
    void should_delete_gadget_type() {
        // Given
        Long id = 1L;
        GadgetType gadgetType = new GadgetTypeMB().withId(id).withDesignation("last name").build();
        when(gadgetTypeRepository.findById(id)).thenReturn(of(gadgetType));

        // When
        deleteGadgetTypeUseCase.execute(id);

        // Then
        verify(gadgetTypeRepository).findById(id);
        verify(gadgetTypeRepository).delete(gadgetType);
        verify(gadgetEventPublisher).publishGadgetTypeDeletingEvent(any());
    }
}
