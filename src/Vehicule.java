public abstract class Vehicule {

    private float vitesseMax;
    private String marque;
    private String modele;
    private String etat;
    private float prixJournalier;

    public Vehicule(float vitesseMax, String marque, String modele, String etat, float prixJournalier) {
        this.vitesseMax = vitesseMax;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
        this.prixJournalier = prixJournalier;
    }

    public float getPrixJournalier() {
        return prixJournalier;
    }
}
