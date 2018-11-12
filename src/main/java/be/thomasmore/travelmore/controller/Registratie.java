package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

//Wouter De Laet registratie
@ManagedBean
@ViewScoped
public class Registratie {

    private Gebruiker newGeruiker = new Gebruiker();
//    private static Cipher ecipher;
//    private static Cipher dcipher;

    @Inject
    private GebruikerService gebruikerService;
//    private static SecretKey key = null;

//    public Registratie() {
//
//        try {
//            FileInputStream fileIn = new FileInputStream("travelmore/src/main/resources/key.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            key = (SecretKey) in.readObject();
//            in.close();
//            fileIn.close();
//
//
//            ecipher = Cipher.getInstance("DES");
//            dcipher = Cipher.getInstance("DES");
//
//            ecipher.init(Cipher.ENCRYPT_MODE, key);
//            dcipher.init(Cipher.DECRYPT_MODE, key);
//
//        } catch (InvalidKeyException e) {
//            System.out.println("Invalid Key:" + e.getMessage());
//            return;
//
//        } catch (NoSuchPaddingException e) {
//            System.out.println("No Such Padding:" + e.getMessage());
//            return;
//
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("No Such Algorithm:" + e.getMessage());
//            return;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


    public Gebruiker getNewGeruiker() {
        return newGeruiker;
    }

    public void setNewGeruiker(Gebruiker newGeruiker) {
        this.newGeruiker = newGeruiker;
    }

    public  String Registreren(){
        this.gebruikerService.insert(newGeruiker);

        String user = newGeruiker.getNaam();
        boolean isAdmin = newGeruiker.getAdmin();
        int id = newGeruiker.getId();

        HttpSession session = SessionUtils.getSession();
        session.setAttribute("naam", user);
        session.setAttribute("isAdmin", isAdmin);
        session.setAttribute("id", id);
        return "index";
    }

//    public static String encrypt(String wachtwoord){
//        try {
//            byte[] utf8 = wachtwoord.getBytes("UTF8");
//            byte[] enc = ecipher.doFinal(utf8);
//
//            enc = BASE64EncoderStream.encode(enc);
//
//            return new String(enc);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static String decrypt(String wachtwoord){
//        try {
//            byte [] dec = BASE64DecoderStream.decode(wachtwoord.getBytes());
//            byte [] utf8 = dcipher.doFinal(dec);
//
//            return new String(utf8, "UTF8");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
