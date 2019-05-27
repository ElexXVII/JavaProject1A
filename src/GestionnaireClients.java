import java.util.ArrayList;

public class GestionnaireClients {

    private ArrayList<Client> clients = new ArrayList<>();

    public Client getClient (int id) {
        return clients.get(id);
    }

    public int getNbClients () {
        return clients.size();
    }

    public void ajouterClient (Client c) {
        clients.add(c);
    }

}
