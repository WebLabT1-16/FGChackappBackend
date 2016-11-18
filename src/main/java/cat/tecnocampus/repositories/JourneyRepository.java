package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by roure on 18/11/2016.
 */
public interface JourneyRepository extends JpaRepository<Journey, Long> {

    @Query("select j from Journey j where (select s.nom from Station s where s.id = j.origin) = ?1 " +
            "and (select s.nom from Station s where s.id = j.destination) = ?2")
    Journey findByOriginAndDestination(String origin, String destination);
}
