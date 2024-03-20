package FabioGilardi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    //    ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String name;
    protected String city;

    //    CONSTRUCTORS
    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Location() {
    }

    //    GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
