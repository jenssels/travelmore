package be.thomasmore.travelmore.controller;



import be.thomasmore.travelmore.domain.Transportmiddeltype;
import be.thomasmore.travelmore.service.TransportmiddeltypeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class TransportmiddeltypeController {

    @Inject
    private TransportmiddeltypeService transportmiddeltypeService;

    // Jens Sels - Ophalen van alle transportmiddel types
    public List<Transportmiddeltype> getTransportmiddeltypes(){
        return transportmiddeltypeService.findAll();
    }
}
