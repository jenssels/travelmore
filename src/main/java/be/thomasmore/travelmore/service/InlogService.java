package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.repository.InlogRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class InlogService {

    @Inject
    private InlogRepository inlogRepository;

    public Gebruiker inloggen(String email)
    {
        return inlogRepository.inloggen(email);
    }
}
