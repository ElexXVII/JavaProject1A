public abstract class VehiculeTerrestre extends Vehicule{

    private int km;
    private float puissance;

    public VehiculeTerrestre(String modele, String marque, float prixJournalier, float vitesseMax, String etat, int km, float puissance) {
        super(modele, marque,prixJournalier, vitesseMax,  etat);
        this.km = km;
        this.puissance = puissance;
    }

    protected abstract String printType();
}
