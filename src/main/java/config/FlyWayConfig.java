package config;

import org.flywaydb.core.Flyway;

public class FlyWayConfig {

    private static final String URL = "jdbc:postgres://ec2-52-54-212-232.compute-1.amazonaws.com:5432/d8doha15rkcust";
    private static final String USER = "mqjzrxouhrymkf";
    private static final String PASSWORD = "7dd361b637f02dc6638d62c5ebc4ab2c4b8380320acb5708e63a07d5bfbd9e92";
    private static final String SCHEMA = "public";
    private static final String LOCATION = "db/migration";

    private FlyWayConfig() {
    }

    public static Flyway configureFlyway() {
        return Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .schemas(SCHEMA)
                .baselineOnMigrate(true)
                .locations(LOCATION)
                .load();
    }
}
