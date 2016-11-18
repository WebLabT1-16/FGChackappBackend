package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.FavoriteJourney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roure on 18/11/2016.
 */
public interface FavoriteJourneyRepository extends JpaRepository<FavoriteJourney,Long> {
}
