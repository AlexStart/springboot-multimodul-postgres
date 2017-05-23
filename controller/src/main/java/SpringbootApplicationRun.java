import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by gladivs on 23.05.2017.
 */
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"my.springboot.multimodul.postgres.*"})
@EntityScan(basePackages = {"my.springboot.multimodul.postgres.*"})
public class SpringbootApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplicationRun.class, args);
    }
}
