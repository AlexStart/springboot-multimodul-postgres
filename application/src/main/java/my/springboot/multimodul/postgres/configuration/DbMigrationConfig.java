package my.springboot.multimodul.postgres.configuration;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by gladivs on 24.05.2017.
 */
@Configuration
@Profile(value = {"dev", "prod"})
public class DbMigrationConfig {

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
    @Primary
    //@FlywayDataSource
    public DataSource dataSource() {
        System.out.println("@@@@@@@@@@@@@@ "+DB_URL+" @@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@ "+DB_USERNAME+" @@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@ "+DB_PASSWORD+" @@@@@@@@@@@@@@@");
        getConnection();
        return (DataSource)DataSourceBuilder.create().url(DB_URL).username(DB_USERNAME).password(DB_PASSWORD).type(DataSource.class).build();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private void getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://ec2-174-129-224-33.compute-1.amazonaws.com:5432/d2cn30qe4vu3nb", "jeykvnwxfrhbdb", "2664e1cf6bf9f23d302f95aca3210dc2b006a9c238d686e73fc2bc2ce9d33192");
            System.out.println("********************* CONNECTION OK *********************");
            System.out.println(connection.getCatalog());
        } catch (Exception e) {
            System.out.println("********************* Connection Failed! Check output console *************************");
            e.printStackTrace();
            return;
        }
    }
}
