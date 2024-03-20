package FabioGilardi.entities;

import FabioGilardi.enums.Sex;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    //    ATTRIBUTES
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private String mail;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany
    @JoinTable(name = "partecipations_persons",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "partecipation_id"))
    private List<Partecipation> partecipationList;

    //    CONSTRUCTORS
    public Person(String name, String surname, String mail, LocalDate birthDate, Sex sex, List<Partecipation> partecipationList) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.birthDate = birthDate;
        this.sex = sex;
        this.partecipationList = partecipationList;
    }

    public Person() {
    }

    //    METHODS
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Partecipation> getPartecipationList() {
        return partecipationList;
    }

    public void setPartecipationList(List<Partecipation> partecipationList) {
        this.partecipationList = partecipationList;
    }

    //    TO STRING
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", partecipationList=" + partecipationList +
                '}';
    }
}
