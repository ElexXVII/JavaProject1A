public abstract class Vehicule extends ParcAgent
{
    static private int carID = 0;
    private int id;
    //private static int nbClients = 0;

    private float vitesseMax;
    private String marque;
    private String modele;
    private String etat;
    private float prixJournalier;

    public Vehicule( String modele, String marque, float prixJournalier, float vitesseMax, String etat) {
        //this.id = nbClients;
        this.vitesseMax = vitesseMax;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
        this.prixJournalier = prixJournalier;

        this.id = carID;
        carID++;
    }

    public float getPrixJournalier() {
        return prixJournalier;
    }

    protected abstract String printType ();

    public String getDisplay()
    {
        return id + " - " + modele + " " + marque;
    }

    public int getId() {
        return id;
    }

    public float getVitesseMax() {
        return vitesseMax;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        return "" + this.id + ". " + this.marque + " " + this.modele + " (" + this.printType() + ")";
    }
}
