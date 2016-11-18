package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.Station;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by roure on 16/11/2016.
 */
public interface StationRepository extends JpaRepository<Station, Long> {

    Station findByNom(@Param("nom") String nom);

}
