package com.demater.core.port;

import com.demater.core.domain.gadget.GadgetConfirmation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface GadgetConfirmationRepository {
    Optional<GadgetConfirmation> findById(UUID id);
    GadgetConfirmation save(GadgetConfirmation gadgetConfirmation);
    List<GadgetConfirmation> saveAll(List<GadgetConfirmation> gadgetConfirmations);
    List<GadgetConfirmation> findAll();

    List<GadgetConfirmation> getGadgetsSent(Map<String, String> query);
}
