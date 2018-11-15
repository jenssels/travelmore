package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betalingsmiddel;
import be.thomasmore.travelmore.service.BetalingsmiddelService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@ViewScoped
public class BetalingsmiddelController {
    @Inject
    BetalingsmiddelService betalingsmiddelService;


    public List<Betalingsmiddel> getBetalingsmiddelen(){
       return betalingsmiddelService.findAll();
    }


}
