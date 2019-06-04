import java.io.Serializable;

public class Client extends ParcAgent
{
    static private int clientID = 0;
    private int id;

    //private static int nbClients;
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Client(String name, String surname, String phone, String address)
    {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;

        this.id = clientID;
        clientID++;
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

    public String getPhone() {
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
