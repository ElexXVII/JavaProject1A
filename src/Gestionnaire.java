import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Gestionnaire {

    private ArrayList<Vehicule> vehicules = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Contrat> contrats = new ArrayList<>();

    /** Vehicules **/

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public Vehicule getVehicule (int id) {
        return vehicules.get(id);
    }

    public int getNbVehicules () {
        return vehicules.size();
    }

    public void ajouterVehicule (Vehicule v) {
        vehicules.add(v);
    }

    /** Clients **/

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Client getClient (int id) {
        return clients.get(id);
    }

    public int getNbClients () {
        return clients.size();
    }

    public void ajouterClient (Client c) {
        clients.add(c);
    }

    /** Contrats **/

    public ArrayList<Contrat> getContrats() {
        return contrats;
    }

    public Contrat getContrat (int id) {
        return contrats.get(id);
    }

    public int getNbContrats () {
        return contrats.size();
    }

    public void ajouterContrat (Contrat c) {
        contrats.add(c);
    }

    /** XML **/

    public void chargerVehicules () {
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

    public void sauvegarderVehicules () {
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


    public void chargerClients () {
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

    public void sauvegarderClients () {
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


    public void chargerContrats () {
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

    public void sauvegarderContrats () {
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
