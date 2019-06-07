package Class;

import java.time.Duration;
import java.util.Calendar;

public class Contrat extends ParcAgent
{
    static private int contractID = 0;
    private int id;

    private Client client;
    private Vehicule vehicule;
    private Calendar debutLoc;
    private Calendar finLoc;
    private int kmEstime;

    private int duree;

    public Calendar getDebutLoc() {
        return debutLoc;
    }

    public void setDebutLoc(Calendar debutLoc) {
        this.debutLoc = debutLoc;
    }

    public Calendar getFinLoc() {
        return finLoc;
    }

    public void setFinLoc(Calendar finLoc) {
        this.finLoc = finLoc;
    }

    public boolean isReduction() {
        return reduction;
    }

    private boolean reduction;

    public Contrat() {
    }

    public static int getContractID() {
        return contractID;
    }

    public static void setContractID(int contractID) {
        Contrat.contractID = contractID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public int getKmEstime() {
        return kmEstime;
    }

    public void setKmEstime(int kmEstime) {
        this.kmEstime = kmEstime;
    }

    public boolean getReduction() {
        return reduction;
    }

    public void setReduction(boolean reduction) {
        this.reduction = reduction;
    }

    public float getPrixEstime() {
        return prixEstime;
    }

    public void setPrixEstime(float prixEstime) {
        this.prixEstime = prixEstime;
    }

    //private Duration duree;
    private float prixEstime;

    public Contrat(Client client, Vehicule vehicule, Calendar debutLoc, Calendar finLoc, int kmEstime, boolean reduction) {
        this.client = client;
        this.vehicule = vehicule;
        this.debutLoc = debutLoc;
        this.finLoc = finLoc;
        this.kmEstime = kmEstime;

        if (this.reductionAutorisee()) {
            this.reduction = reduction;
        } else {
            this.reduction = false;
        }

        this.duree = Math.abs((int)Duration.between(debutLoc.toInstant(), finLoc.toInstant()).toDays());

        this.prixEstime = this.calculerPrix();

        this.id = contractID;
        contractID ++;
    }

    private boolean reductionAutorisee () {

        return duree >= 7;
    }

    private float calculerPrix () {

        float res = 0;
        int kmRestants = kmEstime - 50;
        int kmAjoutes;

        res += vehicule.getPrixJournalier();

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

    public String getDisplay()
    {
        return id + " - " + client.getName() + " " + vehicule.getModele();
    }

}
