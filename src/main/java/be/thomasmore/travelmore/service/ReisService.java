package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.repository.ReisRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Stateless
public class ReisService {
    @Inject
    private ReisRepository reisRepository;

    // Jens Sels - Ophalen van Reis object
    public Reis findReisById(int id){
        return reisRepository.findById(id);
    }

    // Jens Sels - Ophalen van alle reizen
    public List<Reis> findAllReizen(){
        return reisRepository.findAll();
    }

    // Jens Sels - Aanmaken van nieuw Reis object
    public Reis getNewReis(){
        Reis reis = new Reis();
        return reis;
    }

    public List<Reis> findAllReizenSearch(Double budget, Locatie vertrekLocatie, Locatie bestemming, Date startDatum, Date eindDatum){
        // Jens Sels - Lege inputs opvangen en opvullen
        return reisRepository.zoek(budget, vertrekLocatie, bestemming, startDatum, eindDatum);
    }
}
