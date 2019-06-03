import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class GestionnaireVehicules implements Serializable {

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    private ArrayList<Vehicule> vehicules = new ArrayList<>();


    public Vehicule getVehicule (int id) {
        return vehicules.get(id);
    }

    public int getNbVehicules () {
        return vehicules.size();
    }

    public void ajouterVehicule (Vehicule v) {
        vehicules.add(v);
    }

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

}
