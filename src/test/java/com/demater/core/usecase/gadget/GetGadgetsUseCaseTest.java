package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetMB;
import com.demater.core.domain.gadget.Gadget;
import com.demater.core.port.GadgetRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetGadgetsUseCaseTest {
    @Mock
    private GadgetRepository gadgetRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private GetGadgetsUseCase getGadgetsUseCase;

    @BeforeEach
    void setUp() {
        getGadgetsUseCase = new GetGadgetsUseCase(gadgetRepository, gadgetEventPublisher);
    }

    @Test
    void should_get_all_gadgets() {
        // Given
        Gadget gadget1 = new GadgetMB().withDesignation("B").build();
        Gadget gadget2 = new GadgetMB().withDesignation("A").build();
        when(gadgetRepository.findAll()).thenReturn(List.of(gadget1, gadget2));

        // When
        List<Gadget> results = getGadgetsUseCase.execute(Map.of());

        // Then
        verify(gadgetRepository).findAll();
        assertThat(results).hasSize(2)
                .extracting(Gadget::getDesignation)
                .containsExactlyInAnyOrder("A", "B");
        verify(gadgetEventPublisher).publishGadgetsGetting(any());
    }

    @Test
    void should_get_all_gadgets_with_query() {
        // Given
        Gadget gadget1 = new GadgetMB().withDesignation("B").build();
        Gadget gadget2 = new GadgetMB().withDesignation("A").build();
        when(gadgetRepository.findAll()).thenReturn(List.of(gadget1, gadget2));

        // When
        List<Gadget> results = getGadgetsUseCase.execute(Map.of("designation", "B"));

        // Then
        verify(gadgetRepository).findAll();
        assertThat(results).hasSize(1)
                .extracting(Gadget::getDesignation)
                .contains("B");
        verify(gadgetEventPublisher).publishGadgetsGetting(any());
    }
}
