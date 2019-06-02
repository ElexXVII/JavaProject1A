public class Client extends ParcAgent
{
    private int clientID;
    private int id;

    private static int nbClients;
    private String name;
    private String surname;
    private int phone;
    private String address;

    public Client(String name, String surname, int phone, String address)
    {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;

        this.id = clientID++;
    }

    public String getDisplay()
    {
        return id + " - " + name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" + this.id + ". " + this.name;
    }
}
