package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by roure on 14/11/2016.
 */
@RepositoryRestResource//(tokenProjection = TokenProjection.class)
public interface UserRepository extends JpaRepository<User,String> {

    User findByEmail(@Param("email") String email);

    TokenProjection findByUsername(@Param("username") String username);

}
