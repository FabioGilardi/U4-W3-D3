package FabioGilardi.dao;

import FabioGilardi.entities.Person;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(Person person) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("The person " + person.getName() + " has been saved correctly");
    }

    public Person findById(long id) {
        Person personFound = em.find(Person.class, id);
        if (personFound == null) throw new NotFoundException(id);
        return personFound;
    }

    public void deletFromDB(long id) {
        Person personFound = this.findById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(personFound);
        transaction.commit();
        System.out.println("The person " + personFound.getName() + " has been deleted correctly");
    }
}
