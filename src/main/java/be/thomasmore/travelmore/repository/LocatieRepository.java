package be.thomasmore.travelmore.repository;


import be.thomasmore.travelmore.domain.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LocatieRepository {
    @PersistenceContext(unitName="travelMorePU")
    private EntityManager entityManager;

    // Jens Sels - Ophalen van alle locaties
    public List<Locatie> findAll(){
        return entityManager.createNamedQuery(Locatie.findAll, Locatie.class).getResultList();
    }

    // Jolien Lauwers - Zoek locatie via id
    public Locatie findById(int id) {
        return entityManager.find(Locatie.class, id);
    }

    // Jolien Lauwers - Voeg locatie toe
    public void insert(Locatie locatie) {
        entityManager.persist(locatie);
        entityManager.flush();
    }
}
