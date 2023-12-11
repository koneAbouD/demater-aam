package com.demater.core.usecase.station;

import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.event.station.RecoveringSentGadgetsEvent;
import com.demater.core.port.GadgetConfirmationRepository;
import com.demater.core.publisher.StationEventPublisher;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.demater.core.domain.common.StringUtils.isValueContains;

@RequiredArgsConstructor
public class RecoveringGadgetsSentUseCase {
    private final GadgetConfirmationRepository gadgetConfirmationRepository;
    private final StationEventPublisher stationEventPublisher;

    public List<GadgetConfirmation> execute(Map<String, String> query) {
        List<GadgetConfirmation> gadgetConfirmations = gadgetConfirmationRepository.findAll();
        List<GadgetConfirmation> results = gadgetConfirmations;
        if (!query.isEmpty()) {
            results = gadgetConfirmations.stream()
                    .filter(g -> isValueContains(g.stationName(), query.get("station")))
                    .filter(g -> isValueContains(g.gadgetName(), query.get("gadget")))
                    .filter(g -> hasStatus(g, query.get("status")))
                    .filter(g -> hasIntegrationDateIn(g, query.get("dates")))
                    .toList();
        }
        stationEventPublisher.publishRecoveringSentGadgets(new RecoveringSentGadgetsEvent(query));
        return results;
    }

    private boolean hasStatus(GadgetConfirmation gadgetConfirmation, String status) {
        if (status != null) {
            return gadgetConfirmation.getStatus().isLike(status);
        }
        return true;
    }

    private boolean hasIntegrationDateIn(GadgetConfirmation gadgetConfirmation, String dates) {
        if (dates != null) {
            String[] dateSplit = dates.split(";");
            LocalDate beginDate = LocalDate.parse(dateSplit[0]);
            LocalDate endDate = LocalDate.parse(dateSplit[1]);
            return (gadgetConfirmation.getIntegrationDate().toLocalDate().isAfter(beginDate) &&
                    gadgetConfirmation.getIntegrationDate().toLocalDate().isBefore(endDate)) ||
                    gadgetConfirmation.getIntegrationDate().toLocalDate().isEqual(beginDate) ||
                    gadgetConfirmation.getIntegrationDate().toLocalDate().isEqual(endDate);
        }
        return true;
    }
}
