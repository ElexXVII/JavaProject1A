package Class;

/**
 * Classe Moto, fille de {@link VehiculeTerrestre}
 * Pas de paramètres spécifiques
 */

public class Moto extends VehiculeTerrestre {

    /**
     * Constructeur vide pour la sérialisation XML
     */
    public Moto () {
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
     */
    public Moto( String modele, String marque, float prixJournalier, float vitesseMax, String etat, int km, float puissance) {
        super(modele, marque,prixJournalier, vitesseMax,  etat,  km, puissance);
        this.setClassName("Moto");
    }

}
