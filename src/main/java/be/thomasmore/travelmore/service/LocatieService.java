package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.repository.LocatieRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LocatieService {

    @Inject
    private LocatieRepository locatieRepository;

    // Jens Sels - Ophalen van alle locaties
    public List<Locatie> findAllLocaties(){
        return locatieRepository.findAll();
    }

    // Jolien Lauwers - Zoek locatie via id
    public Locatie findLocationById(int id) {
        return locatieRepository.findById(id);
    }

    // Jolien Lauwers - Voeg locatie toe
    public void insert(Locatie locatie) {
        locatieRepository.insert(locatie);
    }
}
