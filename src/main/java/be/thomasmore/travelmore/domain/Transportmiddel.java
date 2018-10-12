package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "transportmiddel")
public class Transportmiddel {
    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "maximumCapaciteit")
    private int maximumCapaciteit;
    @JoinColumn(name = "transportmiddelTypeId")
    private Transportmiddeltype transportmiddeltype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getMaximumCapaciteit() {
        return maximumCapaciteit;
    }

    public void setMaximumCapaciteit(int maximumCapaciteit) {
        this.maximumCapaciteit = maximumCapaciteit;
    }

    public Transportmiddeltype getTransportmiddeltype() {
        return transportmiddeltype;
    }

    public void setTransportmiddeltype(Transportmiddeltype transportmiddeltype) {
        this.transportmiddeltype = transportmiddeltype;
    }
}
