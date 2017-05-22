package my.springboot.multimodul.postgres.persistence.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Саша on 22.05.2017.
 */
@Configuration
@PropertySource(value = "classpath:application-test.properties")
@EnableJpaRepositories(basePackages = {"my.springboot.multimodul.postgres.persistence"})
@ComponentScan(basePackages = {"my.springboot.multimodul.postgres.persistence", "my.springboot.multimodul.postgres.domain"})
public class TestConfiguration {
}
