package be.thomasmore.travelmore.controller;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.NoSuchAlgorithmException;

public class Serialize {
    private static SecretKey key;

    public static void main(String [] args) {

        try {
            key = KeyGenerator.getInstance("DES").generateKey();
        }
        catch (NoSuchAlgorithmException e)

        {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        }
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("travelmore/src/main/resources/key.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(key);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in travelmore/src/main/resources/key.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
