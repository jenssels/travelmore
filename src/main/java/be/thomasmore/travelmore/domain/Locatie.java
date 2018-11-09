package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;


@NamedQueries(
        {
                @NamedQuery(
                        name = Locatie.findAll,
                        query = "SELECT l FROM Locatie l"
                )
        }
)
@Entity
@Table(name = "locatie")
public class Locatie {
    public static final String findAll = "Locatie.findAll";

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locatie other = (Locatie) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }
}
