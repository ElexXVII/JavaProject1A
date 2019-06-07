package Class;

import java.time.Duration;
import java.util.Calendar;

/**
 * Classe Contrat, fille de {@link ParcAgent}
 * Représente un contrat, liant un {@link Client} à un {@link Vehicule}
 * Il possère en plus une date de ddébut et une date de fin, ainsi qu'une distance estimée.
 * On en déduit le booléen reduction disant si le contrat a utilisé la réduction, et l'entier duree représentantle nombre du jours du contrat.
 * On calcule à la validation du contrat le prix basé sur la distance estimée.
 * Ses getters et setters sont nécessaires pour la sérialisation XML.
*/

 public class Contrat extends ParcAgent
{
    static private int contractID = 0;
    private int id;

    private Client client;
    private Vehicule vehicule;
    private Calendar debutLoc;
    private Calendar finLoc;
    private int kmEstime;

    private float prixEstime;

    private int duree;
    private boolean reduction;

    /**
     * Constructeur vide pour la sérialisation XML
     */
    public Contrat() {
    }

    /**
     * Constructeur pour la création d'un contrat avec initialisation.
     * @param client {@link Client}
     * @param vehicule {@link Vehicule}
     * @param debutLoc {@link Calendar}
     * @param finLoc {@link Calendar}
     * @param kmEstime int
     * @param reduction boolean
     */

    public Contrat(Client client, Vehicule vehicule, Calendar debutLoc, Calendar finLoc, int kmEstime, boolean reduction) {
        this.client = client;
        this.vehicule = vehicule;
        this.debutLoc = debutLoc;
        this.finLoc = finLoc;
        this.kmEstime = kmEstime;

        this.reduction = reduction;

        this.duree = Math.abs((int)Duration.between(debutLoc.toInstant(), finLoc.toInstant()).toDays());
        System.out.println(duree);
        this.prixEstime = this.calculerPrix();

        this.id = contractID;
        contractID ++;
    }

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


    /**
     * Détermine si la réduction est autorisée pour ce contrat (si la durée du contrat est supérieure à 7 jours
     * @return boolean
     */
    private boolean reductionAutorisee () {

        return (duree >= 7);
    }

    /**
     * Calcule le prix estimé en se basant sur la table des prix fournie par le sujet, le nombre de km estimé, la durée du contrat et la présence ou non de la réduction
     * @return int
     */
    private float calculerPrix () {

        float res = 0;
        int kmRestants = kmEstime - 50;
        int kmAjoutes;

        res += vehicule.getPrixJournalier() * this.duree;


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

    /**
     * Renvoie la chaîne de caractères représentant le contrat, affichée dans le panneau latéral de la page "Mes Contrats"
     * @return String
     */
    public String toString()
    {
        return id + " - " + client.getName() + " " + vehicule.getModele() + "     " + this.prixEstime + "€";
    }

}
