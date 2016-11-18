package cat.tecnocampus.domain;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Created by roure on 18/11/2016.
 */
@Entity
public class DayTimeStart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DAYTIME_ID")
    private long id;

    private LocalTime begin;

    private DayOfWeek dayOfWeek;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
