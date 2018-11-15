package be.thomasmore.travelmore.domain;

import javax.persistence.*;
@NamedQueries(
        {
                @NamedQuery(
                        name = Boeking.findAllForGebruiker,
                        query = "SELECT b FROM Boeking b where b.gebruiker = :gebruiker"
                ),
                @NamedQuery(
                        name = Boeking.getCountWhereReis,
                        query = "SELECT count(b) FROM Boeking b where b.reis = :reis"
                )
        }
)
@Entity
@Table(name = "boeking")
public class Boeking {
    public static final String findAllForGebruiker = "Boeking.findAllForGebruiker";
    public static final String getCountWhereReis = "Boeking.getCountWhereReis";

    @Id
    private int id;
    @Column(name = "aantalPersonen")
    private int aantalPersonen;
    @Column(name = "prijsbetaling")
    private double prijsbetaling;
    @Column(name = "isBetaald")
    private boolean isBetaald;
    @ManyToOne
    @JoinColumn(name = "gebruikerId")
    private Gebruiker gebruiker;
    @ManyToOne
    @JoinColumn(name = "reisId")
    private Reis reis;
    @ManyToOne
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

    public Double getTotaalPrijs(){
        return this.prijsbetaling * aantalPersonen;
    }

    public String betalingInorde(){
        if (this.isBetaald){
            return "Betaald";
        }
        else{
            return "Nog niet betaald";
        }
    }
}
