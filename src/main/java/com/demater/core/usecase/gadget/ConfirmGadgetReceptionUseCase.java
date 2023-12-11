package com.demater.core.usecase.gadget;

import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.domain.user.User;
import com.demater.core.event.gadget.GadgetConfirmationEvent;
import com.demater.core.port.GadgetConfirmationRepository;
import com.demater.core.port.UserRepository;
import com.demater.core.publisher.GadgetEventPublisher;
import com.demater.core.usecase.common.exception.UserNotFoundException;
import com.demater.core.usecase.gadget.exception.GadgetConfirmationException;
import com.demater.core.usecase.gadget.exception.GadgetConfirmationNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ConfirmGadgetReceptionUseCase {
    private final UserRepository userRepository;
    private final GadgetConfirmationRepository gadgetConfirmationRepository;
    private final GadgetEventPublisher gadgetEventPublisher;

    public GadgetConfirmation execute(String login, UUID uuid) {
        User user = userRepository.findByEmailOrLogin(login)
                .orElseThrow(() -> new UserNotFoundException("User [" + login + "] ot found"));
        GadgetConfirmation gadgetConfirmation = gadgetConfirmationRepository.findById(uuid)
                .orElseThrow(() -> new GadgetConfirmationNotFoundException("Gadget confirmation [" + uuid + "] not found"));

        if (!gadgetConfirmation.getStationGadget().hasUserInStation(user)) {
            throw new GadgetConfirmationException("User [" + login +
                    "] can't confirm gadget reception for station [" + gadgetConfirmation.getStationGadget().stationName() +"]");
        }

        gadgetConfirmation.receive(user);
        GadgetConfirmation gadgetConfirmationSaved = gadgetConfirmationRepository.save(gadgetConfirmation);
        gadgetEventPublisher.publishGadgetReception(new GadgetConfirmationEvent(login, uuid));
        return gadgetConfirmationSaved;
    }
}
