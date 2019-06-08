package Class;

/**
 * Classe Avion, fille de {@link VehiculeAerien}
 * Pas de paramètres spécifiques
 */

public class Avion extends VehiculeAerien {

    /**
     * Constructeur vide pour la sérialisation XML
     */
    public Avion () {

    }

    /**
     * Constructeur d'un avion avec tous ses paramètres
     * @param modele String
     * @param marque String
     * @param prixJournalier float
     * @param vitesseMax float
     * @param etat String
     * @param heuresVol int
     * @param nbMoteurs int
     */
    public Avion(String modele, String marque, float prixJournalier, float vitesseMax, String etat, int heuresVol, int nbMoteurs) {
        super(vitesseMax, marque, modele, etat, prixJournalier, heuresVol, nbMoteurs);
        this.setClassName("Avion");
    }
}
