package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name = "betalingsmiddel")
public class Betalingsmiddel {
    @Id
    private int id;
    @Column(name = "naam")
    private String naam;

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
}
