package my.springboot.multimodul.postgres.persistence;

import my.springboot.multimodul.postgres.domain.Recommendation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gladivs on 18.05.2017.
 */
public interface IRecommendationRepository extends CrudRepository<Recommendation, Long> {
}
