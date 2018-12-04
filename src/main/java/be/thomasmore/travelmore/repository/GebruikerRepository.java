package be.thomasmore.travelmore.repository;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//import static be.thomasmore.travelmore.controller.Registratie.encrypt;


public class GebruikerRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public void insert(Gebruiker gebruiker) {

        gebruiker.setAdmin(false);
//        gebruiker.setWachtwoord(encrypt(gebruiker.getWachtwoord()));

        entityManager.persist(gebruiker);
    }

    // Jens Sels - Ophalen van gebruiker via ID
    public Gebruiker findById(int id){
        return entityManager.find(Gebruiker.class, id);
    }

    public List<Gebruiker> findAll(){
        return entityManager.createNamedQuery(Gebruiker.FIND_ALL, Gebruiker.class).getResultList();
    }

    public void updateAdminLevel(Gebruiker gebruiker){
        entityManager.merge(gebruiker);
    }
}
