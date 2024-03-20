package FabioGilardi.dao;

import FabioGilardi.entities.Events;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventsDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(Events event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();
        System.out.println("The event " + event.getName() + " has been saved correctly");
    }

    public Events findById(long id) {
        Events eventFound = em.find(Events.class, id);
        if (eventFound == null) throw new NotFoundException(id);
        return eventFound;
    }

    public void deletFromDB(long id) {
        Events eventFound = this.findById(id);
        
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(eventFound);
        transaction.commit();
        System.out.println("The event " + eventFound.getName() + " has been deleted correctly");
    }
}
