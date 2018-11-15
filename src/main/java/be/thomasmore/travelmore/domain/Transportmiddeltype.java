package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(
                        name = Transportmiddeltype.findAll,
                        query = "SELECT t FROM Transportmiddeltype t"
                )
        }
)
@Entity
@Table(name = "transportmiddelType")
public class Transportmiddeltype {
    public static final String findAll = "Transportmiddeltype.findAll";

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
        final Transportmiddeltype other = (Transportmiddeltype) obj;
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