package com.demater.core.domain.gadget;

import com.demater.core.domain.station.Station;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.domain.user.User;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.demater.core.domain.gadget.EIntegrationStatus.CONFIRMED;
import static java.time.LocalDateTime.now;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GadgetConfirmation {
    private UUID id;
    private Long gadgetNumberReceived;
    private LocalDateTime integrationDate;
    private EIntegrationStatus status;
    private LocalDateTime confirmationDate;
    private User user;
    private StationGadget stationGadget;

    public void receive(User user) {
        this.user = user;
        this.status = CONFIRMED;
        this.confirmationDate = now();
    }

    public String stationName() {
        return getStationGadget().stationName();
    }

    public String gadgetName() {
        return getStationGadget().gadgetName();
    }

    public Station station() {
        return getStationGadget().getStation();
    }

    public Gadget gadget() {
        return getStationGadget().getGadget();
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
