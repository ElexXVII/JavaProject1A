package Class;

/**
 * Classe Client, fille de {@link ParcAgent}
 * Représente un client, ayant un nom, prénom, numéro de téléphone, adresses mail et postale
 * Il peut être lié à un ou plusieurs {@link Vehicule} par un ou plusieurs {@link Contrat}
 * Ses getters et setters sont nécessaires pour la sérialisation XML.
 */

public class Client extends ParcAgent
{
    static private int clientID = 0;
    private int id;

    private String name;
    private String surname;
    private String phone;
    private String mail;
    private String address;

    /**
     * Constructeur vide pour la sérialisation XML
     */
    public Client() {
    }

    /**
     * Constructeur pour la création d'un client avec tous ses paramètres
     * @param name String
     * @param surname String
     * @param phone String
     * @param mail String
     * @param address String
     */
    public Client(String name, String surname, String phone, String mail, String address)
    {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.address = address;

        this.id = clientID;
        clientID++;
    }
    /**
     * Getter de String mail
     * @return mail
     */
    public String getMail() {
        return mail;
    }
    /**
     * Setter de String mail
     * @param mail String
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Getter de clientId
     * @return clientId
     */
    public static int getClientID() {
        return clientID;
    }

    /**
     * Setter de clientId
     * @param clientID int
     */
    public static void setClientID(int clientID) {
        Client.clientID = clientID;
    }

    /**
     * Getter de id
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Setter de id
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Rend la chaîne de caractères associée au client, qui est affichée dans le panneau latéral de la page "Mes Clients"
     * @return String
     */
    public String toString()
    {
        return id + " - " + name + " " + surname;
    }
}
