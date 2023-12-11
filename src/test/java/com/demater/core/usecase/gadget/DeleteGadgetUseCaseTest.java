package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetMB;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.event.gadget.GadgetDeletingEvent;
import com.demater.core.port.GadgetRepository;
import com.demater.core.publisher.GadgetEventPublisher;
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
class DeleteGadgetUseCaseTest {
    @Mock
    private GadgetRepository gadgetRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private DeleteGadgetUseCase deleteGadgetUseCase;

    @BeforeEach
    void setUp() {
        deleteGadgetUseCase = new DeleteGadgetUseCase(gadgetRepository, gadgetEventPublisher);
    }

    @Test
    void should_throw_when_delete_gadget_with_gadget_dont_exists() {
        // Given
        UUID id = UUID.randomUUID();
        when(gadgetRepository.findById(id)).thenReturn(empty());

        // When
        Exception exception = assertThrows(GadgetNotFoundException.class, () -> deleteGadgetUseCase.execute(id));

        // Then
        assertEquals("Gadget ID=[" + id + "] don't exists", exception.getMessage());
        verify(gadgetRepository).findById(id);
        verify(gadgetRepository, never()).save(any(Gadget.class));
        verify(gadgetEventPublisher, never()).publishGadgetDeleting(new GadgetDeletingEvent(id));
    }

    @Test
    void should_delete_gadget() {
        // Given
        UUID id = UUID.randomUUID();
        Gadget gadget = new GadgetMB().withId(id).build();
        when(gadgetRepository.findById(id)).thenReturn(of(gadget));

        // When
        deleteGadgetUseCase.execute(id);

        // Then
        verify(gadgetRepository).findById(id);
        verify(gadget).makeUnavailable();
        verify(gadgetRepository).save(gadget);
        verify(gadgetEventPublisher).publishGadgetDeleting(any());
    }
}
