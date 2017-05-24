package my.springboot.multimodul.postgres.dbmigration;


import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by gladivs on 24.05.2017.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${datasource.flyway.url}")
    private String DB_URL;
    @Value("${datasource.flyway.driver-class-name}")
    private String DB_DRIVER;
    @Value("${datasource.flyway.username}")
    private String DB_USERNAME;
    @Value("${datasource.flyway.password}")
    private String DB_PASSWORD;
    @Value("${flyway.locations}")
    private String SCRIPTS_LOCATION;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations(SCRIPTS_LOCATION);
        flyway.setDataSource(dataSource());

        return flyway;
    }

    @Bean
    @FlywayDataSource
    public DataSource dataSource() {
        return DataSourceBuilder.create().url(DB_URL).driverClassName(DB_DRIVER).username(DB_USERNAME).password(DB_PASSWORD).build();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
