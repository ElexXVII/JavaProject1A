import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;

public class Client {

    private static int nbClients;
    private int id;

    private String nom;

    public Client(String nom, boolean reduction, Vehicule vehiculeLoue, Temporal debutLoc, Temporal finLoc, int kmEstime) {

        this.id = nbClients;
        this.nom = nom;

        nbClients++;
    }

}
