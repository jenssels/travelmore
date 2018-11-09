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
}
