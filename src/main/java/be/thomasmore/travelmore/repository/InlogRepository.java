package be.thomasmore.travelmore.repository;

import be.thomasmore.travelmore.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InlogRepository {

    @PersistenceContext(unitName = "travelMorePU")
    private EntityManager entityManager;

    public Gebruiker inloggen(String email){

        return entityManager.createNamedQuery(Gebruiker.INLOGGEN, Gebruiker.class).setParameter("email", email).getSingleResult();
    }
}
