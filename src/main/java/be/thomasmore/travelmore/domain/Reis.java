package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "reis")
@NamedQueries(
        {
                @NamedQuery(
                        name = Reis.findAll,
                        query = "SELECT r FROM Reis r"
                ),
                @NamedQuery(
                        name = Reis.searchWhere,
                        query = "SELECT r FROM Reis r WHERE r.prijs >= :minBudget AND r.prijs < :maxBudget AND r.vertreklocatie = :locatie"
                )

        }
)
public class Reis {
    public static final String findAll = "Reis.findAll";
    public static final String searchWhere = "Reis.searchWhere";

    @Id
    private int id;
    @Column(name = "beginDatum")
    private Date beginDatum;
    @Column(name = "eindDatum")
    private Date eindDatum;
    @Column(name = "prijs")
    private double prijs;
    @ManyToOne
    @JoinColumn(name = "transportMiddelId")
    private Transportmiddel transportmiddel;
    @ManyToOne
    @JoinColumn(name = "vertrekLocatieId")
    private Locatie vertreklocatie;
    @ManyToOne
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

    // Jens Sels - Formateer begin datum
    public String getBeginDatumString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        return format.format(this.beginDatum);

    }

    // Jens Sels - Formateer eind datum
    public String getEindDatumString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        return format.format(this.eindDatum);

    }
}
