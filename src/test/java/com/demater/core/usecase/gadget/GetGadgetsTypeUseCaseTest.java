package com.demater.core.usecase.gadget;

import com.demater.builder.GadgetTypeMB;
import com.demater.core.domain.gadget.GadgetType;
import com.demater.core.publisher.GadgetEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.LENIENT;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = LENIENT)
class GetGadgetsTypeUseCaseTest {
    @Mock
    private GadgetTypeRepository gadgetTypeRepository;
    @Mock
    private GadgetEventPublisher gadgetEventPublisher;
    private GetGadgetsTypeUseCase getGadgetsTypeUseCase;

    @BeforeEach
    void setUp() {
        getGadgetsTypeUseCase = new GetGadgetsTypeUseCase(gadgetTypeRepository, gadgetEventPublisher);
    }


    @Test
    void should_get_gadgets_types() {
        // Given
        List<GadgetType> gadgetTypesExisting = List.of(new GadgetTypeMB().withId(1L).withDesignation("B").build(),
                new GadgetTypeMB().withId(2L).withDesignation("A").build());
        when(gadgetTypeRepository.findAll()).thenReturn(gadgetTypesExisting);

        // When
        List<GadgetType> results = getGadgetsTypeUseCase.execute();

        // Then
        verify(gadgetTypeRepository).findAll();
        assertThat(results).hasSize(2)
                .extracting(GadgetType::getId, GadgetType::getDesignation)
                .containsOnly(tuple(2L, "A"), tuple(1L, "B"));
        verify(gadgetEventPublisher).publishAllGadgetsTypeGetting(any());
    }
}
