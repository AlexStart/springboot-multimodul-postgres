package my.springboot.multimodul.postgres.service.impl;


import my.springboot.multimodul.postgres.domain.Recommendation;
import my.springboot.multimodul.postgres.persistence.IRecommendationRepository;
import my.springboot.multimodul.postgres.service.IRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gladivs on 18.05.2017.
 */
@Service
public class RecommendationServiceImpl implements IRecommendationService {
    @Autowired
    private IRecommendationRepository recommendationRepository;

    @Override
    public List<Recommendation> createUserRecommendations(Long userId, List<Recommendation> recommendations) {
        if(userId == null || recommendations == null || recommendations.size() == 0) {
            throw  new IllegalArgumentException("Illegal Arguments");
        }

        for(Recommendation recommendation : recommendations) {
            recommendation.setUserId(userId);
        }

        return (List<Recommendation>)recommendationRepository.save(recommendations);
    }
}
