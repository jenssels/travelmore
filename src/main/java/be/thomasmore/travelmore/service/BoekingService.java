package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.BoekingRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class BoekingService {
    @Inject
    private BoekingRepository boekingRepository;

    // Jens Sels - Opslagen van boeking van een bepaalde reis voor de ingelogde gebruiker
    public void createBoeking(Boeking boeking){
        boekingRepository.createBoeking(boeking);
    }

    // Jens Sels - Ophalen van alle boekingen van een gebruiker
    public List<Boeking> getAllBoekingenForGebruiker(Gebruiker gebruiker){
        return boekingRepository.getAllBoekingenForGebruiker(gebruiker);
    }

    // Jens Sels - Updaten van een boeking
    public void updateBoeking(Boeking boeking){
        boekingRepository.updateBoeking(boeking);
    }

    public int getCountWhereReis(Reis reis){
        return boekingRepository.getCountWhereReis(reis);
    }

    // Jens Sels - Ophalen van een boeking
    public Boeking findById(int id){
        return  boekingRepository.findById(id);
    }


    // Jens Sels - Verwijderen van een boeking
    public void deleteById(Boeking boeking){
        boekingRepository.deleteById(boeking);
    }
}
