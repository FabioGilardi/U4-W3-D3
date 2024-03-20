package FabioGilardi.dao;

import FabioGilardi.entities.Partecipation;
import FabioGilardi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipationDAO {
    //    ATTRIBUTES
    private final EntityManager em;

    //    CONSTRUCTOR
    public PartecipationDAO(EntityManager em) {
        this.em = em;
    }

    //    DB METHODS
    public void saveOnDB(Partecipation partecipation) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipation);
        transaction.commit();
        System.out.println("The partecipation " + partecipation.getId() + " has been saved correctly");
    }

    public Partecipation findById(long id) {
        Partecipation partecipationFound = em.find(Partecipation.class, id);
        if (partecipationFound == null) throw new NotFoundException(id);
        return partecipationFound;
    }

    public void deletFromDB(long id) {
        Partecipation partecipationFound = this.findById(id);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(partecipationFound);
        transaction.commit();
        System.out.println("The partecipation " + partecipationFound.getId() + " has been deleted correctly");
    }
}
