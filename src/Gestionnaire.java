import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public abstract class Gestionnaire {

    private static ArrayList<Vehicule> vehicules = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Contrat> contrats = new ArrayList<>();

    /** Vehicules **/

    public static ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public static Vehicule getVehicule (int id) {
        return vehicules.get(id);
    }

    public static int getNbVehicules () {
        return vehicules.size();
    }

    public static void ajouterVehicule (Vehicule v) {
        vehicules.add(v);
    }

    /** Clients **/

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static Client getClient (int id) {
        return clients.get(id);
    }

    public static int getNbClients () {
        return clients.size();
    }

    public static void ajouterClient (Client c) {
        clients.add(c);
    }

    /** Contrats **/

    public static ArrayList<Contrat> getContrats() {
        return contrats;
    }

    public static Contrat getContrat (int id) {
        return contrats.get(id);
    }

    public static int getNbContrats () {
        return contrats.size();
    }

    public static void ajouterContrat (Contrat c) {
        contrats.add(c);
    }

    /** XML **/

    public static void chargerVehicules () {
        XMLDecoder decoder;
        try {
           decoder = new XMLDecoder(new FileInputStream("vehicules.xml"));
        } catch (FileNotFoundException e) {
            decoder = null;
            e.printStackTrace();
        }

        assert decoder != null;
        vehicules = (ArrayList<Vehicule>)decoder.readObject();

        decoder.close();
    }

    public static void sauvegarderVehicules () {
        XMLEncoder encoder;
        try {
            encoder = new XMLEncoder(new FileOutputStream("vehicules.xml"));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }

        assert encoder != null;
        encoder.writeObject(vehicules);

        encoder.close();
    }


    public static void chargerClients () {
        XMLDecoder decoder;
        try {
            decoder = new XMLDecoder(new FileInputStream("clients.xml"));
        } catch (FileNotFoundException e) {
            decoder = null;
            e.printStackTrace();
        }

        assert decoder != null;
        clients = (ArrayList<Client>)decoder.readObject();

        decoder.close();
    }

    public static void sauvegarderClients () {
        XMLEncoder encoder;
        try {
            encoder = new XMLEncoder(new FileOutputStream("clients.xml"));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }

        assert encoder != null;
        encoder.writeObject(clients);

        encoder.close();
    }


    public static void chargerContrats () {
        XMLDecoder decoder;
        try {
            decoder = new XMLDecoder(new FileInputStream("contrats.xml"));
        } catch (FileNotFoundException e) {
            decoder = null;
            e.printStackTrace();
        }

        assert decoder != null;
        contrats = (ArrayList<Contrat>)decoder.readObject();

        decoder.close();
    }

    public static void sauvegarderContrats () {
        XMLEncoder encoder;
        try {
            encoder = new XMLEncoder(new FileOutputStream("contrats.xml"));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }

        assert encoder != null;
        encoder.writeObject(contrats);

        encoder.close();
    }
}
