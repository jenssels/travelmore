package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.ReisService;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Date;

@ManagedBean
@ViewScoped
public class ReisController {


    @Inject
    private ReisService reisService;

    // Jens Sels - Variabelen voor het filteren op reizen
    private Double zoekBudget;

    private List<Reis> reizen;

    private Locatie zoekVertrekLocatie;

    private Locatie zoekBestemming;

    private Date zoekStartDatum;

    private Date zoekEindDatum;

    // Jens Sels - Ophalen van alle reizen on page load en initializeren van variablen.
    @PostConstruct
    public void init(){
        this.reizen = this.reisService.findAllReizen();
        this.zoekBudget = 0.0;
    }




    // Jens Sels - Terug geven van list met reizen
    public List<Reis> getReizen(){
        return this.reizen;
    }


    // Jens Sels - Ophalen van alle reizen gebaseerd op de zoek criteria
    public void zoek(){
        this.reizen = this.reisService.findAllReizenSearch(this.zoekBudget, this.zoekVertrekLocatie, this.zoekBestemming, this.zoekStartDatum, this.zoekEindDatum);
    }

    // Getters and Setters
    public Double getZoekBudget() {
        return zoekBudget;
    }

    public void setZoekBudget(Double zoekBudget) {
        this.zoekBudget = zoekBudget;
    }

    public Locatie getZoekVertrekLocatie() {
        return zoekVertrekLocatie;
    }

    public void setZoekVertrekLocatie(Locatie zoekVertrekLocatie) {
        this.zoekVertrekLocatie = zoekVertrekLocatie;
    }

    public Date getZoekEindDatum() {
        return zoekEindDatum;
    }

    public void setZoekEindDatum(Date zoekEindDatum) {
        this.zoekEindDatum = zoekEindDatum;
    }

    public Date getZoekStartDatum() {
        return zoekStartDatum;
    }

    public void setZoekStartDatum(Date zoekStartDatum) {
        this.zoekStartDatum = zoekStartDatum;
    }

    public Locatie getZoekBestemming() {
        return zoekBestemming;
    }

    public void setZoekBestemming(Locatie zoekBestemming) {
        this.zoekBestemming = zoekBestemming;
    }

}
