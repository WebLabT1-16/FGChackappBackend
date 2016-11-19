package cat.tecnocampus.restControllers;

import cat.tecnocampus.domain.FavoriteJourney;
import cat.tecnocampus.domain.Journey;
import cat.tecnocampus.domain.Ride;
import cat.tecnocampus.domain.User;
import cat.tecnocampus.repositories.FavoriteJourneyRepository;
import cat.tecnocampus.repositories.JourneyRepository;
import cat.tecnocampus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/users/{username}/favoriteJourney")
    public FavoriteJourney saveFavoriteJourney(@PathVariable String username, @RequestBody FavoriteJourney favoriteJourney) {

        setIdIfExistsInDB(favoriteJourney.getJourney());

        User user = userRepository.findOne(username);

        List<FavoriteJourney> list = new ArrayList<>();
        list.add(favoriteJourney);

        user.setFavoriteJourneyList(list);

        userRepository.save(user);

        return favoriteJourney;
    }

    @PostMapping("/users/{username}/ride")
    public Ride saveRide(@PathVariable String username, @RequestBody Ride ride) {

        setIdIfExistsInDB(ride.getJourney());
        User user = userRepository.findOne(username);

        List<Ride> list = new ArrayList<>();
        list.add(ride);

        user.setRideList(list);

        userRepository.save(user);

        return ride;
    }


    //Set id to avoid repeating the journey in DB
    //Journey should be identified by origin and destination stations
    private void setIdIfExistsInDB(Journey journey) {
        Journey storedJourney = journeyRepository.findByOriginAndDestination(journey.getOrigin().getNom(), journey.getDestination().getNom());
        if (storedJourney != null) journey.setId(storedJourney.getId());
    }
}
