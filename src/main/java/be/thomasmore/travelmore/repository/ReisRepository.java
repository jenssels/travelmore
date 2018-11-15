package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.domain.Transportmiddeltype;

import javax.persistence.*;
import java.util.*;

public class ReisRepository {
    @PersistenceContext(unitName="travelMorePU")
    private EntityManager entityManager;

    // Jens Sels - Ophalen van een reis uit de database
    public Reis findById(int id){
        return entityManager.find(Reis.class, id);
    }

    // Jens Sels - Ophalen van alle reisen uit de database die niet in het verleden liggen
    public List<Reis> findAll(){
        Date datumNu = new Date();
       Query query =  entityManager.createNamedQuery(Reis.findAll, Reis.class);
       query.setParameter("datum", datumNu);
       return query.getResultList();
    }

    // Jens Sels - Ophalen van alle reizen gebaseerd op de zoek criteria
    public List<Reis> zoek(Double budget, Locatie vertreklocatie, Locatie bestemming, Date startDatum, Date eindDatum, Transportmiddeltype transportmiddeltype){
        Map<String, Object> paramaterMap = new HashMap<String, Object>();
        List<String> whereCause = new ArrayList<String>();

        Date datumNu = new Date();

        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("select r from Reis r");

        // Reizen die in het verleden liggen worden niet getoond
        whereCause.add(" r.beginDatum >= :datumNu ");
        paramaterMap.put("datumNu", datumNu);

        if (budget != null && budget > 0){
            whereCause.add(" r.prijs < :budget ");
            paramaterMap.put("budget", budget);
        }
        if (vertreklocatie != null){
            whereCause.add(" r.vertreklocatie = :locatie ");
            paramaterMap.put("locatie", vertreklocatie);
        }
        if (bestemming != null){
            whereCause.add(" r.aankomstlocatie = :bestemming ");
            paramaterMap.put("bestemming", bestemming);
        }

        if (startDatum != null && startDatum.compareTo(datumNu) > 0){
            whereCause.add(" r.beginDatum >= :startDatum ");
            paramaterMap.put("startDatum", startDatum);
        }

        if (eindDatum != null && eindDatum.compareTo(datumNu) > 0){
            whereCause.add(" r.eindDatum <= :eindDatum ");
            paramaterMap.put("eindDatum", eindDatum);
        }

        if (transportmiddeltype != null){
            whereCause.add(" r.transportmiddel.transportmiddeltype = :transportmiddeltype ");
            paramaterMap.put("transportmiddeltype", transportmiddeltype);
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