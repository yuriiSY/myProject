package com.config;

import org.flywaydb.core.Flyway;

public class FlyWayConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/projectHibernate";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";
    private static final String SCHEMA = "public";
    private static final String LOCATION = "db/migration";

    private FlyWayConfig() {
    }

    public static Flyway getInstance() {
        return Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .baselineOnMigrate(true)
                .schemas(SCHEMA)
                .locations(LOCATION)
                .load();
    }
}
