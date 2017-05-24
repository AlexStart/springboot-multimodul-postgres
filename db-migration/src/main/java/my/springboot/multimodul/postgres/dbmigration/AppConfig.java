package my.springboot.multimodul.postgres.dbmigration;


import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by gladivs on 24.05.2017.
 */
@Configuration
public class AppConfig {
    @Bean(name = "myFlyway", initMethod = "migrate")
    Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("db/migration");
        flyway.setDataSource(dataSource());

        return flyway;
    }

    @Bean
    //@ConfigurationProperties(prefix = "spring.datasource")
    DataSource dataSource() {
        return DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/user1_db").driverClassName("org.postgresql.Driver").username("postgres").password("alex").build();
    }
}
