package my.springboot.multimodul.postgres.controller.config;

import my.springboot.multimodul.postgres.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gladivs on 22.05.2017.
 */
@Configuration
@Profile(value = {"dev", "prod"})
public class ControllerConfiguration {
    @Bean
    public UserController userController () {
        return new UserController();
    }
}
