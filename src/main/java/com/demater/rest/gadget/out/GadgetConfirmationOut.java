package com.demater.rest.gadget.out;

import com.demater.core.domain.gadget.EIntegrationStatus;
import com.demater.rest.common.out.UserOut;
import com.demater.rest.station.out.StationOut;

import java.time.LocalDateTime;
import java.util.UUID;

public record GadgetConfirmationOut(UUID id,
                                    StationOut station,
                                    GadgetOut gadget,
                                    Long gadgetNumberReceived,
                                    LocalDateTime integrationDate,
                                    EIntegrationStatus status,
                                    LocalDateTime confirmationDate,
                                    UserOut user) {}
