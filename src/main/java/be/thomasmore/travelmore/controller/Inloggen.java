package be.thomasmore.travelmore.controller;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.InlogService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
//import static be.thomasmore.travelmore.controller.Registratie.decrypt;

//Wouter De Laet inloggens
@ManagedBean
@SessionScoped
public class Inloggen {

    private Gebruiker gebruikerIngelogged = new Gebruiker();

    @Inject
    private InlogService inlogService;

    public String inloggen(String email, String wachtwoord)
    {
        gebruikerIngelogged = this.inlogService.inloggen(email);

//        String decrypted = decrypt(gebruikerIngelogged.getWachtwoord());

        System.err.println(gebruikerIngelogged.getMail());
        System.err.println(email);
//        System.err.println(decrypted);
        System.err.println(wachtwoord);
        if(gebruikerIngelogged.getMail().equals(email)  && gebruikerIngelogged.getWachtwoord().equals(wachtwoord))
        {
            boolean isAdmin = gebruikerIngelogged.getAdmin();
            int id = gebruikerIngelogged.getId();
            String user = gebruikerIngelogged.getNaam();
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("naam", user);
            session.setAttribute("isAdmin", isAdmin);
            session.setAttribute("id", id);

            System.err.println("gelukt");
            return "index";
        }
        else
        {
            System.err.println("Niet gelukt");
            return null;
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        System.err.println("FUBAR");
        return "uitgelogged";
    }

    public String backHome(){
        return "index";
    }
}
