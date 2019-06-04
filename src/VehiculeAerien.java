import java.io.Serializable;

public abstract class VehiculeAerien extends Vehicule {

    private int heuresVol;
    private int nbMoteurs;

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
