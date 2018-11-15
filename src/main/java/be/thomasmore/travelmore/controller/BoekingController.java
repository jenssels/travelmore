package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Betalingsmiddel;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.service.ReisService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@ManagedBean
@SessionScoped
public class BoekingController {
    @Inject
    private ReisService reisService;
    @Inject
    BoekingService boekingService;
    @Inject
    private GebruikerService gebruikerService;

    private HttpSession session = SessionUtils.getSession();

    private Reis reis;

    private Boeking boeking;

    private int boekingAantalPersonen;

    private Betalingsmiddel betalingsmiddel;


    // Jens Sels - Ophalen van de gekozen reis en de pagina voor de boeking openen
    public String boekingForm(int id){
        this.reis = this.reisService.findReisById(id);

        return "boekingForm";
    }

    // Jens Sels - Opslagen van boeking van een bepaalde reis voor de ingelogde gebruiker
    public String boek() {
        if (session.getAttribute("naam") != null && this.boekingAantalPersonen > 0) {
            Boeking boeking = new Boeking();

            boeking.setAantalPersonen(this.boekingAantalPersonen);
            boeking.setBetaald(false);
            boeking.setGebruiker(gebruikerService.findById((int)session.getAttribute("id")));
            boeking.setPrijsbetaling(this.reis.getPrijs());
            boeking.setReis(this.reis);

            boekingService.createBoeking(boeking);

            return "mijnBoekingen";
        }
        else{
            return "index";
        }
    }

    // Jens Sels - Ophalen van van alle boekingen van de ingelogde gebruiker
    public List<Boeking> getBoekingen(){
        Gebruiker gebruiker = gebruikerService.findById((int)session.getAttribute("id"));
        if (gebruiker != null){
            return boekingService.getAllBoekingenForGebruiker(gebruiker);
        }
        else{
            return null;
        }
    }

    // Jens Sels - Betaling pagina voor een boeking openen
    public String betalingsForm(int id){
        this.boeking = boekingService.findById(id);
        return "betalingForm";
    }

    // Jens Sels - Betalen van een boeking
    public String betalen(){
        this.boeking.setBetalingsmiddel(this.betalingsmiddel);
        this.boeking.setBetaald(true);

        this.boekingService.updateBoeking(this.boeking);
        return "mijnBoekingen";
    }

    // Jens Sels - Verwijderen van een boeking
    public String verwijder(int id){
        boekingService.deleteById(boekingService.findById(id));
        return "mijnBoekingen";
    }

    public Reis getReis() {
        return reis;
    }

    public int getBoekingAantalPersonen() {
        return boekingAantalPersonen;
    }

    public void setBoekingAantalPersonen(int boekingAantalPersonen) {
        this.boekingAantalPersonen = boekingAantalPersonen;
    }

    public Boeking getBoeking() {
        return boeking;
    }

    public void setBoeking(Boeking boeking) {
        this.boeking = boeking;
    }

    public Betalingsmiddel getBetalingsmiddel() {
        return betalingsmiddel;
    }

    public void setBetalingsmiddel(Betalingsmiddel betalingsmiddel) {
        this.betalingsmiddel = betalingsmiddel;
    }
}
