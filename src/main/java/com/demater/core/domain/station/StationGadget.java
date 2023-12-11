package com.demater.core.domain.station;

import com.demater.core.domain.gadget.Gadget;
import com.demater.core.domain.user.User;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StationGadget {
    private UUID id;
    private Station station;
    private Gadget gadget;
    private Long gadgetNumber;

    public StationGadget(Station station, Gadget gadget, Long gadgetNumber) {
        this.station = station;
        this.gadget = gadget;
        this.gadgetNumber = gadgetNumber;
    }

    public void updateGadgetNumber(Long value) {
        this.gadgetNumber += value;
    }

    public String stationName() {
        return getStation().getDesignation();
    }

    public String gadgetName() {
        return getGadget().getDesignation();
    }

    public boolean hasUserInStation(User user) {
        return getStation().getUsers().stream()
                .anyMatch(u -> u.getLogin().equalsIgnoreCase(user.getLogin()));
    }

    public UUID stationId() {
        return getStation().getId();
    }

    public UUID gadgetId() {
        return getGadget().getId();
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
