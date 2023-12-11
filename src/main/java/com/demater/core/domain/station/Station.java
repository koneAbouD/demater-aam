package com.demater.core.domain.station;

import com.demater.core.domain.referential.City;
import com.demater.core.domain.referential.EStatus;
import com.demater.core.domain.user.User;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import static com.demater.core.domain.referential.EStatus.ACTIVATED;
import static com.demater.core.domain.referential.EStatus.DEACTIVATED;
import static java.util.stream.Collectors.toSet;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Station {
    public static final String DESIGNATION_SEPARATOR_FOR_DELETING = "_";

    private UUID id;
    private String designation;
    private City city;
    private String address;
    private String costCenter;
    private Set<User> users = new HashSet<>();
    private EStatus status;
    private boolean isDeleted;

    public void updateForCreating(City city) {
        this.city = city;
        activate();
    }

    public String cityDesignation() {
        return getCity().getDesignation();
    }

    public Long cityId() {
        return getCity().getId();
    }

    public void activate() {
        this.status = ACTIVATED;
    }

    public void update(String designation,
                       City city,
                       String address,
                       String costCenter,
                       EStatus status,
                       boolean deleted) {
        this.designation = designation;
        this.city = city;
        this.address = address;
        this.costCenter = costCenter;
        this.status = status;
        this.isDeleted = deleted;
    }

    public void deleteAt(Long deleteTime) {
        this.designation = this.designation + DESIGNATION_SEPARATOR_FOR_DELETING + deleteTime;
        this.status = DEACTIVATED;
        this.isDeleted = true;
    }

    public void addUser(User user) {
        users.add(user);
        user.setStation(this);
    }

    public void removeUser(User user) {
        users = getUsers().stream()
                .filter(u -> !(Objects.equals(u.getId(), user.getId()) &&
                        Objects.equals(u.getLogin(), user.getLogin())))
                .collect(toSet());
        user.setStation(null);
    }

    public void updateForCSV(String designation, String address, City city, String costCenter, EStatus status) {
        this.designation = designation;
        this.address = address;
        this.city = city;
        this.costCenter = costCenter;
        this.status = status;
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
