import java.util.Date;

public class Client {

    private int id;
    private String nom;
    private boolean reduction;
    private Vehicule vehiculeLoue;
    private Date debutLoc;
    private Date finLoc;
    private float prixEstime;
    private int kmEstime;


    public float calculerPrix () {

        float res = 0;
        int kmRestants = kmEstime - 50;
        int kmAjoutes;

        res += vehiculeLoue.getPrixJournalier();

        // Ajout des km 50 à 100;
        if (kmRestants > 0) {
            kmAjoutes = Integer.min(kmRestants, 50);
            res += 0.5 * kmAjoutes;
            kmRestants -= kmAjoutes;
        }

        // Ajout des km 100 à 200
        if (kmRestants > 0) {
            kmAjoutes = Integer.min(kmRestants, 100);
            res += 0.3 * kmAjoutes;
            kmRestants -= kmAjoutes;
        }

        // Ajout des km 200 à 300
        if (kmRestants > 0) {
            kmAjoutes = Integer.min(kmRestants, 100);
            res += 0.2 * kmAjoutes;
            kmRestants -= kmAjoutes;
        }

        // Ajout des km > 300
        if (kmRestants > 0) {
            res += 0.1 * kmRestants;
        }

        if (reduction) {
            return 0.9f * res;
        } else {
            return res;
        }
    }
}
