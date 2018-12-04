package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.GebruikerRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GebruikerService {

    @Inject
    private GebruikerRepository gebruikerRepository;

    public void insert(Gebruiker gebruiker){
        gebruikerRepository.insert(gebruiker);
    }

    public Gebruiker findById(int id){
        return gebruikerRepository.findById(id);
    }

    public List<Gebruiker> findAllGebruikers(){
        return gebruikerRepository.findAll();
    }

    public void updateAdminLevel(Gebruiker gebruiker){
        gebruikerRepository.updateAdminLevel(gebruiker);
    }
}
