package FabioGilardi.entities;

import FabioGilardi.enums.EventType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Events {

    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(mappedBy = "eventId")
    protected long id;
    protected String name;
    @Column(name = "event_date")
    protected LocalDate eventDate;
    protected String description;
    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    protected EventType eventType;
    @Column(name = "max_partecipants")
    protected int maxPartecipants;
    @ManyToOne
    @JoinColumn(name = "location_id")
    protected Location locationId;

    //    CONSTRUCTORS
    public Events(String name, LocalDate eventDate, String description, EventType eventType, int maxPartecipants, Location locationId) {
        this.name = name;
        this.eventDate = eventDate;
        this.description = description;
        this.eventType = eventType;
        this.maxPartecipants = maxPartecipants;
        this.locationId = locationId;
    }

    public Events() {

    }

    //    GETTERS AND SETTERS
    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxPartecipants() {
        return maxPartecipants;
    }

    public void setMaxPartecipants(int maxPartecipants) {
        this.maxPartecipants = maxPartecipants;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventDate=" + eventDate +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxPartecipants=" + maxPartecipants +
                ", locationId=" + locationId +
                '}';
    }

    //    EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Events events = (Events) o;
        return id == events.id && maxPartecipants == events.maxPartecipants && Objects.equals(name, events.name) && Objects.equals(eventDate, events.eventDate) && Objects.equals(description, events.description) && eventType == events.eventType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eventDate, description, eventType, maxPartecipants);
    }
}
