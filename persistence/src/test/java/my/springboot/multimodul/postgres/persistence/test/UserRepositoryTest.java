package my.springboot.multimodul.postgres.persistence.test;

import my.springboot.multimodul.postgres.domain.User;
import my.springboot.multimodul.postgres.persistence.IUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by gladivs on 16.05.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("test")
@SpringBootTest(classes = TestConfiguration.class)
public class UserRepositoryTest {

    @Autowired
    private IUserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }

    //TODO :
    //@Ignore
    @Test
    public void saveUserTest() {
        User user = new User();
        user.setFirstName("First Name");
        user.setLastName("Last Name");
        user.setAge(100);

        assertNull(user.getId());

        userRepository.save(user);

        assertNotNull(user.getId());

    }

    @After
    public void tearDown() throws Exception {

    }
}
