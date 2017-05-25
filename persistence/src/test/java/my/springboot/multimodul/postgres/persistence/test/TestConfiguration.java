package my.springboot.multimodul.postgres.persistence.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by Саша on 22.05.2017.
 */
@Configuration
@ActiveProfiles("test")
@PropertySource(value = "classpath:application-test.properties")
@EnableJpaRepositories(basePackages = "my.springboot.multimodul.postgres.*")
@EntityScan(basePackages = {"my.springboot.multimodul.postgres.*"})
public class TestConfiguration {
}
