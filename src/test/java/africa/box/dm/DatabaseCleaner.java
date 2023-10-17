package africa.box.dm;

import africa.box.dm.db.entities.CreditCardParameter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DatabaseCleaner {

    private final Class<?>[] ENTITY_TYPE = {
            CreditCardParameter.class
    };

    private final EntityManager entityManager;

    DatabaseCleaner (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void clean() {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        for (Class<?> enityType:ENTITY_TYPE) {
            deleteEntity(enityType);
        }
    }


    private void deleteEntity(Class<?> entityType) {
        entityManager
                .createQuery("delete from "+ entityType.getName())
                .executeUpdate();
    }
}
