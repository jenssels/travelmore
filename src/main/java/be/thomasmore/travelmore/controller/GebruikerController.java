package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class GebruikerController {

    @Inject
    private GebruikerService gebruikerService;

    public List<Gebruiker> getGebruikers(){
        return gebruikerService.findAllGebruikers();
    }

    public String maakAdmin(boolean isAdmin, int id)
    {
        Gebruiker gebruiker = new Gebruiker();

        gebruiker = gebruikerService.findById(id);
        gebruiker.setAdmin(isAdmin);

        System.out.println(gebruiker.getAdmin() + " is nu een admin " );

        gebruikerService.updateAdminLevel(gebruiker);

        return "gebruikersOverzicht";

    }
}
