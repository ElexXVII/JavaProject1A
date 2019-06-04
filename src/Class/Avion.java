package Class;

public class Avion extends VehiculeAerien {

    public Avion(float vitesseMax, String marque, String modele, String etat, float prixJournalier, int heuresVol, int nbMoteurs) {
        super(vitesseMax, marque, modele, etat, prixJournalier, heuresVol, nbMoteurs);
    }

    @Override
    protected String printType() {
        return "Class.Avion";
    }
}
