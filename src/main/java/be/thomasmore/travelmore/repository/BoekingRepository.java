package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BoekingRepository {
    @PersistenceContext(unitName="travelMorePU")
    private EntityManager entityManager;

    // Jens Sels - Aanmaken van boeking voor bepaalde reis van een gebruiker
    public void createBoeking(Boeking boeking){
        entityManager.persist(boeking);
    }

    // Jens Sels - Ophalen van een boeking
    public Boeking findById(int id){
        return entityManager.find(Boeking.class, id);
    }

    // Jens Sels - Verwijderen van een boeking
    public void deleteById(Boeking boeking){
        boeking = entityManager.merge(boeking);
        entityManager.remove(boeking);
    }

    // Jens Sels - Wijzigen van een boeking opslagen
    public void updateBoeking(Boeking boeking){
        entityManager.merge(boeking);
    }

    // Jens Sels - Ophalen van alle boekingen van een gebruiker
    public List<Boeking> getAllBoekingenForGebruiker(Gebruiker gebruiker){
        return entityManager.createNamedQuery(Boeking.findAllForGebruiker, Boeking.class).setParameter("gebruiker", gebruiker).getResultList();
    }

    // Jens Sels - Ophalen van hoeveel boekingen er zijn van een bepaalde reis
    public int getCountWhereReis(Reis reis){
        Long result = entityManager.createNamedQuery(Boeking.getCountWhereReis, Long.class).setParameter("reis", reis).getSingleResult();
        return  result.intValue( );
    }
}
