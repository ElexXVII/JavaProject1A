import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class GestionnaireVehicules implements Serializable {

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
           decoder = new XMLDecoder(new FileInputStream("vehicules.json"));
        } catch (FileNotFoundException e) {
            decoder = null;
            e.printStackTrace();
        }

        ajouterVehicule((Vehicule)decoder.readObject());

        decoder.close();
    }

}
