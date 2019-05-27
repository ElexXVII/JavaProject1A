public class Voiture extends VehiculeTerrestre {

    private int nbPlaces;

    public Voiture(float vitesseMax, String marque, String modele, String etat, float prixJournalier, int km, float puissance, int nbPlaces) {
        super(vitesseMax, marque, modele, etat, prixJournalier, km, puissance);
        this.nbPlaces = nbPlaces;
    }

    @Override
    protected String printType() {
        return "Voiture";
    }


}