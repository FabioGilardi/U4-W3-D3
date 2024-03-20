package FabioGilardi.entities;


import FabioGilardi.enums.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "partecipations")
public class Partecipation {

    //    ATTRIBUTES
    @OneToOne
    @JoinColumn(name = "event_id")
    Events eventId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "partecipationList")
    private List<Person> personList;
    @Enumerated(EnumType.STRING)
    private Status status;

    //    CONSTRUCTORS
    public Partecipation(Events eventId, List<Person> personList, Status status) {
        this.eventId = eventId;
        this.personList = personList;
        this.status = status;
    }

    public Partecipation() {
    }

    //    GETTERS AND SETTERS
    public Events getEventId() {
        return eventId;
    }

    public void setEventId(Events eventId) {
        this.eventId = eventId;
    }

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Partecipation{" +
                "eventId=" + eventId +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
