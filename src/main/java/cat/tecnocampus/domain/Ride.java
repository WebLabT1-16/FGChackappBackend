package cat.tecnocampus.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by roure on 14/11/2016.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RIDE_ID")
    private long id;

    @JsonFormat(pattern = "dd:MM:yyyy HH:mm:ss")
    private LocalDateTime begin;

    @JsonFormat(pattern = "dd:MM:yyyy HH:mm:ss")
    private LocalDateTime end;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "JOURNEY_ID")
    private Journey journey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", begin=" + begin +
                ", end=" + end +
                ", journey=" + journey +
                '}';
    }
}
