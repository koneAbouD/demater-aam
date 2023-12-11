package com.demater.rest.station.out;

import com.demater.core.domain.referential.EStatus;
import com.demater.rest.common.out.CityOut;
import com.demater.rest.common.out.UserOut;

import java.util.Set;
import java.util.UUID;

public record StationOut(UUID id,
                         String designation,
                         CityOut city,
                         String address,
                         String costCenter,
                         Set<UserOut> users,
                         EStatus status,
                         boolean isDeleted) {
}
