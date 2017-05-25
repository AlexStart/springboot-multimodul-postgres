package my.springboot.multimodul.postgres.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by gladivs on 25.05.2017.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "my.springboot.multimodul.postgres.*")
@ComponentScan(basePackages = {"my.springboot.multimodul.postgres.*"})
@EntityScan(basePackages = {"my.springboot.multimodul.postgres.*"})
@Profile(value = {"dev", "prod"})
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
