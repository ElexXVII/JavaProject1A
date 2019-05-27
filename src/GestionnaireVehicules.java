import java.util.ArrayList;

public class GestionnaireVehicules {

    private ArrayList<Vehicule> vehicules = new ArrayList<>();

    public Vehicule getVehicule (int id) {
        return vehicules.get(id);
    }

    public int getNbVehicules () {
        return vehicules.size();
    }

}
