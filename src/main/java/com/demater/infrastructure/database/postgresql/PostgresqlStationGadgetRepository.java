package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.station.StationGadget;
import com.demater.core.port.StationGadgetRepository;
import com.demater.infrastructure.database.entity.station.StationGadgetEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class PostgresqlStationGadgetRepository implements StationGadgetRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final ObjectMapper objectMapper;

    @Override
    public Set<StationGadget> findAllByStationAndGadgetIn(UUID stationId, Set<UUID> gadgetsIds) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<StationGadgetEntity> cr = cb.createQuery(StationGadgetEntity.class);
        Root<StationGadgetEntity> root = cr.from(StationGadgetEntity.class);

        Predicate whereStationIs = cb.equal(root.get("station").get("id"), stationId);
        Predicate whereGadgetIn = root.get("gadget").get("id").in(gadgetsIds);
        cr.select(root).where(cb.and(whereStationIs, whereGadgetIn));

        return  session.createQuery(cr)
                .getResultList()
                .stream()
                .map(s -> objectMapper.convertValue(s, StationGadget.class))
                .collect(toSet());
    }
}
