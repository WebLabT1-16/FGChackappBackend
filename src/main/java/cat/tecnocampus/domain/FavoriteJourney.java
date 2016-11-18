package cat.tecnocampus.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;

/**
 * Created by roure on 14/11/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class FavoriteJourney {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FAVORITE_JOURNEY_ID")
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FAVORITE_JOURNEY_ID", referencedColumnName = "FAVORITE_JOURNEY_ID", nullable = false)
    private List<DayTimeStart> StartList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "JOURNEY")
    private Journey journey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DayTimeStart> getStartList() {
        return StartList;
    }

    public void setStartList(List<DayTimeStart> startList) {
        StartList = startList;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public String toString() {
        return "FavoriteJourney{" +
                "id=" + id +
                ", StartList=" + StartList +
                ", journey=" + journey +
                '}';
    }
}
