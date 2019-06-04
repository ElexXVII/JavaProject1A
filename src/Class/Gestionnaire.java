package Class;

import GUI.TArray;
import Interface.Definition;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Gestionnaire implements Definition
{

    public Gestionnaire() {}

    private static ArrayList<Vehicule> vehicules = new ArrayList<>();
    private static ArrayList vehiculesTest = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Contrat> contrats = new ArrayList<>();

    public static void initArrayList()
    {
        clients.add(Tony);
        clients.add(George);
        clients.add(Marcel);

        vehicules.add(Twingo);
        vehicules.add(Clio2);
        vehicules.add(R8);

        vehiculesTest.add(Twingo);
        vehiculesTest.add(Clio2);
        vehiculesTest.add(R8);
    }

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

    public static void sauvegarder()
    {
        sauvegarderClients();
        sauvegarderContrats();
        sauvegarderVehicules();
    }

    public static void charger()
    {
        chargerClients();
        chargerContrats();
        chargerVehicules();
    }

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

    private static void sauvegarderVehicules () {
        XMLEncoder encoder;

        TArray a = new TArray(vehicules);
        FileOutputStream f = null;

        try {
            f = new FileOutputStream("vehicules.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        encoder = new XMLEncoder(f);

        encoder.writeObject(vehiculesTest);

        encoder.close();

        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private static void sauvegarderClients () {
        XMLEncoder encoder;

        TArray a = new TArray(clients);

        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("clients.xml")));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }

        encoder.writeObject(a);

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

        contrats = (ArrayList<Contrat>) decoder.readObject();

        decoder.close();
    }

    private static void sauvegarderContrats () {
        XMLEncoder encoder;

        TArray a = new TArray(contrats);

        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("contrats.xml")));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }
        encoder.writeObject(a);

        encoder.close();
    }
}
