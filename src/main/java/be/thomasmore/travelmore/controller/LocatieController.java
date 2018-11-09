package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class LocatieController {

    @Inject
    private LocatieService locatieService;

    // Jens Sels - Ophalen van alle locaties
    public List<Locatie> getLocaties(){
        return locatieService.findAllLocaties();
    }
}
