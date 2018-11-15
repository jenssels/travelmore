package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Betalingsmiddel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BetalingsmiddelRepository {
    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public List<Betalingsmiddel> findAll(){
        return entityManager.createNamedQuery(Betalingsmiddel.findAll, Betalingsmiddel.class).getResultList();
    }
}
