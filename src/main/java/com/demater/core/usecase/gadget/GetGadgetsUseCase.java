package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.event.gadget.GadgetsGettingEvent;
import com.demater.core.port.GadgetRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static com.demater.core.domain.common.StringUtils.isValueContains;

@RequiredArgsConstructor
public class GetGadgetsUseCase {
    public static final String TRUE = "true";
    private final GadgetRepository gadgetRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public List<Gadget> execute(Map<String, String> query) {
        List<Gadget> gadgets = getGadgetsFor(query);
        gadgetEventPublisher.publishGadgetsGetting(new GadgetsGettingEvent());
        return gadgets.stream()
                .sorted(Comparator.comparing(Gadget::getDesignation))
                .toList();
    }

    private List<Gadget> getGadgetsFor(final Map<String, String> query) {
        List<Gadget> gadgets = gadgetRepository.findAll();
        // TODO: Add this process in SQL request
        if (!query.isEmpty()) {
            return gadgets.stream()
                    .filter(g -> isValueContains(g.getDesignation(), query.get("designation")))
                    .filter(g -> isValueContains(g.getDescription(), query.get("description")))
                    .filter(g -> isValueContains(g.getDetails(), query.get("details")))
                    .filter(g -> isValueContains(g.typeDesignation(), query.get("type")))
                    .filter(g -> compareGadgetStatus(g.isAvailable(), query.get("isAvailable")))
                    .toList();
        }

        return gadgets;
    }

    private boolean compareGadgetStatus(final boolean isAvailable, final String query) {
        if (query == null) {
            return true;
        }
        return TRUE.equalsIgnoreCase(query) == isAvailable;
    }
}
