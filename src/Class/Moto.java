package Class;

public class Moto extends VehiculeTerrestre {

    public Moto () {

    }

    public Moto( String modele, String marque, float prixJournalier, float vitesseMax, String etat, int km, float puissance) {
        super(modele, marque,prixJournalier, vitesseMax,  etat,  km, puissance);
        this.setClassName("Moto");
    }

    @Override
    protected String printType() {
        return "Moto";
    }
}
