package be.thomasmore.travelmore.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.Column;

@Entity
@Table(name = "locatie")
public class Locatie {
    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "code")
    @Size(min=3, max = 5)
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
