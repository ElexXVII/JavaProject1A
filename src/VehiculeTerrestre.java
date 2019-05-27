public abstract class VehiculeTerrestre extends Vehicule{

    private int km;
    private float puissance;

    public VehiculeTerrestre(float vitesseMax, String marque, String modele, String etat, float prixJournalier, int km, float puissance) {
        super(vitesseMax, marque, modele, etat, prixJournalier);
        this.km = km;
        this.puissance = puissance;
    }
}
