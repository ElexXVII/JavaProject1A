package Class;

public class Avion extends VehiculeAerien {

    public Avion () {

    }

    public Avion(String modele, String marque, float prixJournalier, float vitesseMax, String etat, int heuresVol, int nbMoteurs) {
        super(vitesseMax, marque, modele, etat, prixJournalier, heuresVol, nbMoteurs);
        this.setClassName("Avion");
    }

    @Override
    protected String printType() {
        return "Avion";
    }
}
