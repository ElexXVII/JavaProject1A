package Class;

public class Client extends ParcAgent
{
    static private int clientID = 0;
    private int id;

    //private static int nbClients;
    private String name;
    private String surname;
    private String phone;
    private String mail;
    private String address;

    public Client() {
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public static int getClientID() {
        return clientID;
    }

    public static void setClientID(int clientID) {
        Client.clientID = clientID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String toString()
    {
        return id + " - " + name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }
}
