package cat.tecnocampus.repositories;

import cat.tecnocampus.domain.User;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by roure on 18/11/2016.
 */
public interface TokenProjection {
    String getToken();
}
