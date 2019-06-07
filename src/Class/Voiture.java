package Class;

/**
 * Classe {@link Voiture}, fille de {@link VehiculeTerrestre}
 * Contient un nombre de places
 */
public class Voiture extends VehiculeTerrestre{

    private int nbPlaces;

    /**
     * Constructeur vide pour la sérialisation XML
     */
    public Voiture()
    {
        super();
    }

    /**
     * Constructeur d'un avion avec tous ses paramètres
     * @param modele String
     * @param marque String
     * @param prixJournalier float
     * @param vitesseMax float
     * @param etat String
     * @param km int
     * @param puissance float
     * @param nbPlaces int
     */
    public Voiture( String modele, String marque, float prixJournalier, float vitesseMax, String etat, long km, float puissance, int nbPlaces) {
        super(modele, marque,prixJournalier, vitesseMax,  etat,  km, puissance);
        this.setClassName("Voiture");
        this.nbPlaces = nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

}