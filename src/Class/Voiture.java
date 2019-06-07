package Class;

public class Voiture extends VehiculeTerrestre{

    private int nbPlaces;

    public Voiture()
    {
        super();
    }

    public Voiture( String modele, String marque, float prixJournalier, float vitesseMax, String etat, long km, float puissance, int nbPlaces) {
        super(modele, marque,prixJournalier, vitesseMax,  etat,  km, puissance);
        this.setClassName("Voiture");
        this.nbPlaces = nbPlaces;
    }

    @Override
    protected String printType() {
        return "Voiture";
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

}