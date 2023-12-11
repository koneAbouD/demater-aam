package com.demater.rest.gadget.out;

import java.util.UUID;

public record GadgetOut(UUID id,
                        String designation,
                        GadgetTypeOut type,
                        String description,
                        String details,
                        Long totalNumber,
                        Long remainingNumber,
                        boolean isAvailable) {
}
