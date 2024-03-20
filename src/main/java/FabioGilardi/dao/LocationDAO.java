package FabioGilardi.dao;

import FabioGilardi.entities.Location;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("The location " + location.getName() + " has been saved correctly");
    }

    public Location findById(long id) {
        Location locationFound = em.find(Location.class, id);
        if (locationFound == null) throw new NotFoundException(id);
        return locationFound;
    }

    public void deletFromDB(long id) {
        Location locationFound = this.findById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(locationFound);
        transaction.commit();
        System.out.println("The location " + locationFound.getName() + " has been deleted correctly");
    }
}
