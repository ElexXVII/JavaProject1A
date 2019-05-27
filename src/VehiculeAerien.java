public abstract class VehiculeAerien extends Vehicule {

    private int heuresVol;
    private int nbMoteurs;

    public VehiculeAerien(float vitesseMax, String marque, String modele, String etat, float prixJournalier, int heuresVol, int nbMoteurs) {
        super(vitesseMax, marque, modele, etat, prixJournalier);
        this.heuresVol = heuresVol;
        this.nbMoteurs = nbMoteurs;
    }
}
