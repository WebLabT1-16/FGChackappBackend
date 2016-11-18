package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roure on 18/11/2016.
 */
public interface RideRepository extends JpaRepository<Ride, Long>{
}
