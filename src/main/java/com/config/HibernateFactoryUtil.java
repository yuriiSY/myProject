package com.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateFactoryUtil {
    private static EntityManager entityManager;
    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
        }
        return entityManager;
    }
}
