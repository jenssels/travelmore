package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReisRepository {
    @PersistenceContext(unitName="travelMorePU")
    private EntityManager entityManager;

    // Jens Sels - Ophalen van een reis uit de database
    public Reis findById(int id){
        return entityManager.find(Reis.class, id);
    }

    // Jens Sels - Ophalen van alle reisen uit de database
    public List<Reis> findAll(){
        return entityManager.createNamedQuery(Reis.findAll, Reis.class).getResultList();
    }

    // Jens Sels - Ophalen van alle reizen gebaseerd op de zoek criteria
    public List<Reis> searchwhere(Double minBudget, Double maxBudget, Locatie locatie){
        return entityManager.createNamedQuery(Reis.searchWhere, Reis.class).setParameter("minBudget", minBudget).setParameter("maxBudget", maxBudget).setParameter("locatie", locatie).getResultList();

    }

    public List<Reis> zoek(Double budget, Locatie vertreklocatie){
        Map<String, Object> paramaterMap = new HashMap<String, Object>();
        List<String> whereCause = new ArrayList<String>();

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select r from Reis r");

        if (budget != null && budget > 0){
            whereCause.add(" r.prijs < :budget ");
            paramaterMap.put("budget", budget);
        }
        if (vertreklocatie != null){
            whereCause.add(" r.vertreklocatie = :locatie ");
            paramaterMap.put("locatie", vertreklocatie);
        }

        if (!whereCause.isEmpty()) {
            queryBuilder.append(" where " + String.join(" and ", whereCause));
        }
        TypedQuery jpaQuery = entityManager.createQuery(queryBuilder.toString(), Reis.class);


        for(String key :paramaterMap.keySet()) {
            jpaQuery.setParameter(key, paramaterMap.get(key));
        }



        return  jpaQuery.getResultList();
    }
}