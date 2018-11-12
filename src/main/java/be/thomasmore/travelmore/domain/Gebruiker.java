package be.thomasmore.travelmore.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "gebruiker")
@NamedQueries(
        {
                @NamedQuery(
                        name = Gebruiker.INLOGGEN,
                        query = "SELECT g FROM Gebruiker g WHERE g.mail = :email"
                )
        }
)
public class Gebruiker {
    public static final String INLOGGEN = "Gebruiker.inloggen";
    @Id
    private int id;
    @Column(name = "naam")
    private String naam;
    @Column(name = "adres")
    private String adres;
    @Column(name = "gemeente")
    private String gemeente;
    @Column(name = "mail")
    private String mail;
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @Column(name = "isAdmin")
    private Boolean isAdmin;

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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}