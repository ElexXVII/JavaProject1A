package Class;

/**
 * Classe abstraite {@link VehiculeTerrestre}, fille de {@link Vehicule}
 * Contient un nombre de km parcourus et une puissance
 * Les getters et setters ainsi que le constructeur vide sont nécessaires à la serialisation XML
 */
public abstract class VehiculeTerrestre extends Vehicule{

    private long km;
    private float puissance;


    /**
     * Constructeur vide pour la sérialisation  XML
     */
    public VehiculeTerrestre()
    {
    }

    /**
     * Constructeur pour la création et initialisation d'un {@link VehiculeTerrestre}
     * @param modele String
     * @param marque String
     * @param prixJournalier float
     * @param vitesseMax float
     * @param etat String
     * @param km long
     * @param puissance float
     */
    public VehiculeTerrestre(String modele, String marque, float prixJournalier, float vitesseMax, String etat, long km, float puissance) {
        super(modele, marque,prixJournalier, vitesseMax,  etat);
        this.km = km;
        this.puissance = puissance;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setPuissance(float puissance) {
        this.puissance = puissance;
    }

    public long getKm() {
        return km;
    }

    public float getPuissance() {
        return puissance;
    }
}
