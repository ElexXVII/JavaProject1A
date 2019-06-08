package Class;

import Interface.Definition;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;


/**
 * Classe {@link Gestionnaire} permettant de stocker une liste de {@link Vehicule}, une liste de {@link Client} et une liste de {@link Contrat}
 * Elle permet également les interactions avec les fichiers XML associés en permettant de charger les listes depuis ces fichiers, ou de sauvegarder les listes dans les fichiers.
 */
public class Gestionnaire implements Definition
{

    /**
     * Constructeur vide
     */
    public Gestionnaire() {}

    private static ArrayList<Vehicule> vehicules = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private static ArrayList<Contrat> contrats = new ArrayList<>();

    /* Gestion des véhicules **/

    public static ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public static Vehicule getVehicule (int id) {
        return vehicules.get(id);
    }

    /* Gestion des clients **/

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static Client getClient (int id) {
        return clients.get(id);
    }

    /* Gestion des contrats **/

    public static ArrayList<Contrat> getContrats() {
        return contrats;
    }

    /* Sérialisation XML **/

    /**
     * Initialise les 3 ArrayList avec les valeurs sérialisées
     */
    public static void initArrayList()
    {
        charger();
    }

    /**
     * Sérialise les 3 ArrayList dans les fichiers XML correspondants
     */
    public static void sauvegarder()
    {
        sauvegarderClients();
        sauvegarderContrats();
        sauvegarderVehicules();
    }

    /**
     * Désérialise les 3 ArrayList depuis les fichiers XML correspondants
     */
    private static void charger()
    {
        chargerClients();
        chargerContrats();
        chargerVehicules();
    }

    /**
     * Désérialise les véhicules enregistrés dans vehicules.xml
     */
    private static void chargerVehicules () {
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

        int maxID = 0;
        for (Vehicule vehicule : vehicules)
        {
            if (vehicule.getId() > maxID)
            {
                maxID = vehicule.getId();
            }
        }
        Vehicule.setVehicleId(maxID+1);
    }


    /**
     * Sérialise les véhicules enregistrés dans vehicules.xml
     */
    private static void sauvegarderVehicules () {
        XMLEncoder encoder;

        FileOutputStream f = null;

        try {
            f = new FileOutputStream("vehicules.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        encoder = new XMLEncoder(f);

        encoder.writeObject(vehicules);

        encoder.close();

        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Désérialise les clients enregistrés dans clients.xml
     */
    private static void chargerClients () {
        XMLDecoder decoder;
        try {
            decoder = new XMLDecoder(new FileInputStream("clients.xml"));
        } catch (FileNotFoundException e) {
            decoder = null;
            e.printStackTrace();
        }

        assert decoder != null;

        clients = (ArrayList<Client>) decoder.readObject();

        decoder.close();

        int maxID = 0;
        for (Client client : clients)
        {
            if (client.getId() > maxID)
            {
                maxID = client.getId();
            }
        }
        Client.setClientID(maxID+1);
    }

    /**
     * Sérialise les clients enregistrés dans clients.xml
     */
    private static void sauvegarderClients () {
        XMLEncoder encoder;

        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("clients.xml")));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }

        assert encoder != null;
        encoder.writeObject(clients);

        encoder.close();
    }


    /**
     * Désérialise les contrats enregistrés dans contrats.xml
     */
    private static void chargerContrats () {
        XMLDecoder decoder;
        try {
            decoder = new XMLDecoder(new FileInputStream("contrats.xml"));
        } catch (FileNotFoundException e) {
            decoder = null;
            e.printStackTrace();
        }

        contrats = (ArrayList<Contrat>)decoder.readObject();

        decoder.close();

        int maxID = 0;
        for (Contrat contrat : contrats)
        {
            if (contrat.getId() > maxID)
            {
                maxID = contrat.getId();
            }
        }
        Contrat.setContractID(maxID+1);
    }

    /**
     * Sérialise les contrats enregistrés dans contrats.xml
     */
    private static void sauvegarderContrats () {
        XMLEncoder encoder;

        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("contrats.xml")));
        } catch (FileNotFoundException e) {
            encoder = null;
            e.printStackTrace();
        }
        assert encoder != null;
        encoder.writeObject(contrats);

        encoder.close();
    }
}
