public class Client {

    private static int nbClients;
    private int id;

    private String nom;

    public Client(String nom) {

        this.id = nbClients;
        this.nom = nom;

        nbClients++;
    }

    @Override
    public String toString() {
        return "" + this.id + ". " + this.nom;
    }
}
