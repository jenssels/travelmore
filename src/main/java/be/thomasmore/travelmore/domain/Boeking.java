package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "boeking")
public class Boeking {
    @Id
    private int id;
    @Column(name = "aantalPersonen")
    private int aantalPersonen;
    @Column(name = "prijsbetaling")
    private double prijsbetaling;
    @Column(name = "isBetaald")
    private boolean isBetaald;
    @JoinColumn(name = "gebruikerId")
    private Gebruiker gebruiker;
    @JoinColumn(name = "reisId")
    private Reis reis;
    @JoinColumn(name = "betalingsmiddelId")
    private Betalingsmiddel betalingsmiddel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAantalPersonen() {
        return aantalPersonen;
    }

    public void setAantalPersonen(int aantalPersonen) {
        this.aantalPersonen = aantalPersonen;
    }

    public double getPrijsbetaling() {
        return prijsbetaling;
    }

    public void setPrijsbetaling(double prijsbetaling) {
        this.prijsbetaling = prijsbetaling;
    }

    public boolean isBetaald() {
        return isBetaald;
    }

    public void setBetaald(boolean betaald) {
        isBetaald = betaald;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public Reis getReis() {
        return reis;
    }

    public void setReis(Reis reis) {
        this.reis = reis;
    }

    public Betalingsmiddel getBetalingsmiddel() {
        return betalingsmiddel;
    }

    public void setBetalingsmiddel(Betalingsmiddel betalingsmiddel) {
        this.betalingsmiddel = betalingsmiddel;
    }
}