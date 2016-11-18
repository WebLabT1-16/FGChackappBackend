package cat.tecnocampus.restControllers;

import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domain.Journey;
import cat.tecnocampus.domain.User;
import cat.tecnocampus.repositories.FavoriteJourneyRepository;
import cat.tecnocampus.repositories.JourneyRepository;
import cat.tecnocampus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roure on 18/11/2016.
 */
@RestController
public class userController {

    private UserRepository userRepository;

    private JourneyRepository journeyRepository;

    private FavoriteJourneyRepository favoriteJourneyRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setJourneyRepository(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @Autowired
    public void setFavoriteJourneyRepository(FavoriteJourneyRepository favoriteJourneyRepository) {
        this.favoriteJourneyRepository = favoriteJourneyRepository;
    }

    @PutMapping("/users/{username}/favoriteJourney")
    public FavoriteJourney putFavoriteJourney(@PathVariable String username, @RequestBody FavoriteJourney favoriteJourney) {

        //check whether journey already exists
        Journey journey = favoriteJourney.getJourney();
        Journey storedJourney = journeyRepository.findByOriginAndDestination(journey.getOrigin().getNom(), journey.getDestination().getNom());
        if (storedJourney != null) favoriteJourney.getJourney().setId(storedJourney.getId());
        User user = userRepository.findOne(username);

        List<FavoriteJourney> list = new ArrayList<>();
        list.add(favoriteJourney);

        user.setFavoriteJourneyList(list);

        userRepository.save(user);

        return favoriteJourney;
    }
}
