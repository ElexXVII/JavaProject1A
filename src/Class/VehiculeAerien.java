package Class;

/**
 * Classe abstraite {@link VehiculeAerien}, fille de {@link Vehicule}
 * Contient un nombre d'heures de vol et un nombre de moteurs
 * Les getters et setters ainsi que le constructeur vide sont nécessaires à la serialisation XML
 */

public abstract class VehiculeAerien extends Vehicule {

    private int heuresVol;
    private int nbMoteurs;

    /**
     * Constructeur vide pour la sérialisation XML
     */
    public VehiculeAerien () {

    }


    /**
     * Constructeur pour la création et initialisation d'un {@link VehiculeAerien}
     * @param vitesseMax float
     * @param marque String
     * @param modele String
     * @param etat String
     * @param prixJournalier float
     * @param heuresVol int
     * @param nbMoteurs int
     */
    public VehiculeAerien(float vitesseMax, String marque, String modele, String etat, float prixJournalier, int heuresVol, int nbMoteurs) {
        super( modele, marque, prixJournalier,vitesseMax,  etat);
        this.heuresVol = heuresVol;
        this.nbMoteurs = nbMoteurs;
    }

    public int getHeuresVol() {
        return heuresVol;
    }

    public int getNbMoteurs() {
        return nbMoteurs;
    }

    public void setHeuresVol(int heuresVol) {
        this.heuresVol = heuresVol;
    }

    public void setNbMoteurs(int nbMoteurs) {
        this.nbMoteurs = nbMoteurs;
    }
}
