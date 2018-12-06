package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocatieController {

    private String naam;
    private String code;
    private Locatie newLocation = new Locatie();

    @Inject
    private LocatieService locatieService;

    // Jens Sels - Ophalen van alle locaties
    public List<Locatie> getLocaties(){
        return locatieService.findAllLocaties();
    }

    // Jolien Lauwers
    public void setNewLocation(Locatie newLocation) {
        this.newLocation = newLocation;
    }

    public Locatie getNewLocatie()
    {
        return newLocation;
    }
    public List<Locatie> getLocations(){
        return this.locatieService.findAllLocaties();
    }

    public void submit(){
        this.locatieService.insert(newLocation);
    }

    public String updateLocatie(int id)
    {

        newLocation = locatieService.findLocationById(id);
        newLocation.setNaam(naam);
        newLocation.setCode(code);

        this.locatieService.updateLocatie(newLocation);

        return "locatiesBeheren";
    }

    public String deleteLocatie(int id)
    {
        this.locatieService.deleteLocatie(locatieService.findLocationById(id));

        return "locatiesBeheren";
    }
}
