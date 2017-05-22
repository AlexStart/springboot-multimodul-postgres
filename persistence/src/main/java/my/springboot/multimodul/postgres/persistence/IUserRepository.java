package my.springboot.multimodul.postgres.persistence;

import my.springboot.multimodul.postgres.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gladivs on 16.05.2017.
 */
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
    List<User> findByAgeGreaterThan(String age);
}
