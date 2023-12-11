package com.demater.infrastructure.database.postgresql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.demater.core.domain.gadget.GadgetConfirmation;
import com.demater.core.port.GadgetConfirmationRepository;
import com.demater.infrastructure.database.entity.gadget.GadgetConfirmationEntity;
import com.demater.infrastructure.database.repository.JpaGadgetConfirmationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class PostgresqlGadgetConfirmationRepository implements GadgetConfirmationRepository {
    private final JpaGadgetConfirmationRepository gadgetConfirmationRepository;
    private final ObjectMapper objectMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Optional<GadgetConfirmation> findById(UUID id) {
        Optional<GadgetConfirmationEntity> gadget = gadgetConfirmationRepository.findById(id);
        return gadget.map(g -> objectMapper.convertValue(g, GadgetConfirmation.class));
    }

    @Override
    @Transactional
    public GadgetConfirmation save(GadgetConfirmation gadgetConfirmation) {
        GadgetConfirmationEntity gadgetToSave = objectMapper.convertValue(gadgetConfirmation, GadgetConfirmationEntity.class);
        GadgetConfirmationEntity gadgetSaved = gadgetConfirmationRepository.save(gadgetToSave);
        return objectMapper.convertValue(gadgetSaved, GadgetConfirmation.class);
    }

    @Override
    @Transactional
    public List<GadgetConfirmation> saveAll(List<GadgetConfirmation> gadgetConfirmations) {
        List<GadgetConfirmationEntity> gadgetsToSave = gadgetConfirmations.stream()
                .map(g -> objectMapper.convertValue(g, GadgetConfirmationEntity.class))
                .toList();
        List<GadgetConfirmationEntity> gadgetsSaved = gadgetConfirmationRepository.saveAll(gadgetsToSave);
        return gadgetsSaved.stream()
                .map(g -> objectMapper.convertValue(g, GadgetConfirmation.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<GadgetConfirmation> findAll() {
        return gadgetConfirmationRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(GadgetConfirmationEntity::gadgetName))
                .map(g -> objectMapper.convertValue(g, GadgetConfirmation.class))
                .toList();
    }

    @Override
    public List<GadgetConfirmation> getGadgetsSent(Map<String, String> query) {
        Session session = entityManager.unwrap(Session.class);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<GadgetConfirmationEntity> cr = cb.createQuery(GadgetConfirmationEntity.class);
        Root<GadgetConfirmationEntity> root = cr.from(GadgetConfirmationEntity.class);

        Predicate whereStationIs = cb.equal(root.get("stationGadget").get("station").get("designation"), query.get("station"));
        Predicate whereGadgetIs = cb.equal(root.get("stationGadget").get("gadget").get("designation"), query.get("gadget"));
        Predicate whereStatusIs = cb.equal(root.get("status"), query.get("status"));
        List<LocalDate> dates = splitDateRange(query.get("dates"));
        Predicate whereIntegrationDateIn = cb.between(root.get("integrationDate"), dates.get(0), dates.get(1));
        cr.select(root).where(cb.or(whereStationIs, whereGadgetIs, whereStatusIs, whereIntegrationDateIn));

        return  session.createQuery(cr)
                .getResultList()
                .stream()
                .map(g -> objectMapper.convertValue(g, GadgetConfirmation.class))
                .toList();
    }

    private static List<LocalDate> splitDateRange(String dateRange) {
        if (dateRange == null || Objects.equals(dateRange, "")) {
            return Collections.emptyList(); // TODO: temporary solution, dont pass null as value
        }
        String[] dateStrings = dateRange.split(";");
        return Arrays.stream(dateStrings)
                .map(LocalDate::parse)
                .toList();
    }
}
