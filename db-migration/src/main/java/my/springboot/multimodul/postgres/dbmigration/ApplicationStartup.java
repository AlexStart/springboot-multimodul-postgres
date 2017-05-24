package my.springboot.multimodul.postgres.dbmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

/**
 * Created by gladivs on 24.05.2017.
 */
@SpringBootApplication
//@EnableAutoConfiguration
public class ApplicationStartup {
    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(AppConfig.class, args);
    }
}
