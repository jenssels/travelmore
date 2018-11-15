package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Gebruiker;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import static be.thomasmore.travelmore.controller.Registratie.encrypt;


public class GebruikerRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public void insert(Gebruiker gebruiker) {

        gebruiker.setAdmin(false);
//        gebruiker.setWachtwoord(encrypt(gebruiker.getWachtwoord()));

        entityManager.persist(gebruiker);
    }
}
