public class Moto extends VehiculeTerrestre {

    public Moto( String modele, String marque, float prixJournalier, float vitesseMax, String etat, int km, float puissance) {
        super(modele, marque,prixJournalier, vitesseMax,  etat,  km, puissance);
    }

    @Override
    protected String printType() {
        return "Moto";
    }
}
