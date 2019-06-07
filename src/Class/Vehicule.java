package Class;


/**
 *
 * Vehicule est une classe abstraite factorisant le code nécessaire à tous les types de véhicules.
 * Elle est fille de {@link ParcAgent}
 * Les instances sont sérialisées en XML et doivent donc avoir tous les getters, les setters et un constructeur vide.
 *
 */

public abstract class Vehicule extends ParcAgent
{
    static private int vehicleId = 0;
    private int id;

    private float vitesseMax;
    private String marque;
    private String modele;
    private String etat;
    private float prixJournalier;
    private String className;

    /**
     * Constructeur vide pour la sérialisation
     */
    public Vehicule()
    {

    }

    /**
     * Constructeur contenant tous les attributs nécessaires
     * @param modele String représentant le modèle du véhicule
     * @param marque String représentant la marque du véhicule
     * @param prixJournalier float représentant le prix par jour du véhicule
     * @param vitesseMax float représentant la vitesse maximale du véhicule
     * @param etat String représentant l'état du véhicule
     */
    public Vehicule(String modele, String marque, float prixJournalier, float vitesseMax, String etat) {
        this.vitesseMax = vitesseMax;
        this.marque = marque;
        this.modele = modele;
        this.etat = etat;
        this.prixJournalier = prixJournalier;

        this.id = vehicleId;
        vehicleId++;
    }
    /**
     * Getter de String className
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * Setter de String className
     * @param className nouveau className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Getter de static int vehicleId
     * @return l'identifiant du prochain véhicule créé
     */
    public static int getVehicleId() {
        return vehicleId;
    }

    /**
     * Setter de int vehicleId
     * @param vehicleId nouveau vehicleId
     */
    public static void setVehicleId(int vehicleId) {
        Vehicule.vehicleId = vehicleId;
    }
    
    /**
     * Getter de int id
     * @return l'identifiant du véhicule
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de int id
     * @param id nouveau id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de float vitesseMax
     * @return la vitesse max du véhicule
     */
    public float getVitesseMax() {
        return vitesseMax;
    }

    /**
     * Setter de float vitesseMax
     * @param  vitesseMax nouvelle vitesse max
     */
    public void setVitesseMax(float vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    /**
     * Getter de String marque
     * @return la marque du véhicule
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Setter de String marque
     * @param marque nouvelle marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Getter de String modele
     * @return le modele du véhicule
     */
    public String getModele() {
        return modele;
    }

    /**
     * Setter de String modele
     * @param modele nouveau modèle du véhicule
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     * Getter de String etat
     * @return l'état du véhicule
     */
    public String getEtat() {
        return etat;
    }

    /**
     * Setter de String etat
     * @param etat String représentant l'état du véhicule
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * Getter de float prixJournalier
     * @return le prix journalier du véhicule
     */
    public float getPrixJournalier() {
        return prixJournalier;
    }

    /**
     * Setter de float prixJournalier
     * @param prixJournalier float représentant le prix par jour du véhicule
     */
    public void setPrixJournalier(float prixJournalier) {
        this.prixJournalier = prixJournalier;
    }


    /**
     *
     * @return Une chaîne de caractères représentant le véhicule
     */
    @Override
    public String toString() {
        return "" + this.id + " - " + this.marque + " " + this.modele + " (" + this.className + ")";
    }
}
