public abstract class Vehicule {

    private static int nbClients;

    private int id;
    private float vitesseMax;
    private String marque;
    private String modele;
    private String etat;
    private float prixJournalier;

    public Vehicule(float vitesseMax, String marque, String modele, String etat, float prixJournalier) {
        this.id = nbClients;
        this.vitesseMax = vitesseMax;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
        this.prixJournalier = prixJournalier;

        nbClients++;
    }

    public float getPrixJournalier() {
        return prixJournalier;
    }

    protected abstract String printType ();

    @Override
    public String toString() {
        return "" + this.id + ". " + this.marque + " " + this.modele + " (" + this.printType() + ")";
    }
}
