package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reis")
public class Reis {
    @Id
    private int id;
    @Column(name = "beginDatum")
    private Date beginDatum;
    @Column(name = "eindDatum")
    private Date eindDatum;
    @Column(name = "prijs")
    private double prijs;
    @JoinColumn(name = "transportMiddelId")
    private Transportmiddel transportmiddel;
    @JoinColumn(name = "vertrekLocatieId")
    private Locatie vertreklocatie;
    @JoinColumn(name = "aankomstLocatieId")
    private Locatie aankomstlocatie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginDatum() {
        return beginDatum;
    }

    public void setBeginDatum(Date beginDatum) {
        this.beginDatum = beginDatum;
    }

    public Date getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(Date eindDatum) {
        this.eindDatum = eindDatum;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Transportmiddel getTransportmiddel() {
        return transportmiddel;
    }

    public void setTransportmiddel(Transportmiddel transportmiddel) {
        this.transportmiddel = transportmiddel;
    }

    public Locatie getVertreklocatie() {
        return vertreklocatie;
    }

    public void setVertreklocatie(Locatie vertreklocatie) {
        this.vertreklocatie = vertreklocatie;
    }

    public Locatie getAankomstlocatie() {
        return aankomstlocatie;
    }

    public void setAankomstlocatie(Locatie aankomstlocatie) {
        this.aankomstlocatie = aankomstlocatie;
    }
}
