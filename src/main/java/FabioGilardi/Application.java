package FabioGilardi;


import FabioGilardi.dao.EventsDAO;
import FabioGilardi.dao.LocationDAO;
import FabioGilardi.dao.PartecipationDAO;
import FabioGilardi.dao.PersonDAO;
import FabioGilardi.entities.Events;
import FabioGilardi.exceptions.NotFoundException;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
//      FAKER
        Faker faker = new Faker();

//        CREAZIONE ENTITY MANAGER
        EntityManager em = emf.createEntityManager();

//        CREAZIONE DAO
        EventsDAO eventsDAO = new EventsDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipationDAO partecipationDAO = new PartecipationDAO(em);
        PersonDAO personDAO = new PersonDAO(em);

//        POPOLAMENTO DB
//        for (int i = 0; i < 20; i++) {
//            Random random = new Random();
//            int randomeEventType = random.nextInt(0, 2);
//            List<EventType> typeList = new ArrayList<>();
//            typeList.add(EventType.PUBLIC);
//            typeList.add(EventType.PRIVATE);
//            int randomPartecipants = random.nextInt(10, 101);
//            eventsDAO.saveOnDB(new Events(faker.esports().event(), LocalDate.now(), faker.esports().game(), typeList.get(randomeEventType), randomPartecipants));
//        }

//        LETTURA EVENTI
        try {
            Events event1 = eventsDAO.findById(4);
            System.out.println(event1);
            Events event2 = eventsDAO.findById(11);
            System.out.println(event2);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

//        RIMOZIONE EVENTI
        try {
            eventsDAO.deletFromDB(20);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

//        U4-W3-D3 -----------------------------------------------------------------------------------------------
//        locationDAO.saveOnDB(new Location("Palataurus", "Lecco"));
//        eventsDAO.saveOnDB(new Events("LOL Tournament", LocalDate.now(), "Faboulous lol tournament", EventType.PUBLIC, 50, locationDAO.findById(1)));
//        System.out.println(eventsDAO.findById(1));

//        eventsDAO.saveOnDB(new Events("LOL Tournament", LocalDate.now(), "Faboulous lol tournament", EventType.PUBLIC, 50, locationDAO.findById(1)));
//        partecipationDAO.saveOnDB(new Partecipation(eventsDAO.findById(1), Status.CONFIRMED));
//        System.out.println(partecipationDAO.findById(1));


        em.close();
        emf.close();
    }
}
