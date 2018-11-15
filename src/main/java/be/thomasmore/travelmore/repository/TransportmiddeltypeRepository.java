package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Transportmiddeltype;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TransportmiddeltypeRepository {
    @PersistenceContext(unitName="travelMorePU")
    private EntityManager entityManager;

    // Jens Sels - Ophalen van all transportmiddel types
    public List<Transportmiddeltype> findAll(){
        return entityManager.createNamedQuery(Transportmiddeltype.findAll, Transportmiddeltype.class).getResultList();
    }


}
