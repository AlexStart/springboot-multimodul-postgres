package my.springboot.multimodul.postgres.service;

import my.springboot.multimodul.postgres.domain.Recommendation;

import java.util.List;

/**
 * Created by gladivs on 18.05.2017.
 */
public interface IRecommendationService {
    List<Recommendation> createUserRecommendations(Long userId, List<Recommendation> recommendations);
}
