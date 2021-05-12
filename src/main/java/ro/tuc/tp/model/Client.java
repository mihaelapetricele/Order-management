package ro.tuc.tp.model;

/**
 * Class that name is exact as the table <i>Client</i> from database, and which has the exact same fields
 * @author Petricele Mihaela
 */
public class Client {
    private int idClient;
    private String name;
    private String address;
    private String email;
    private int age;

    /**
     * Constructor with parameters of the Client Class
     * @param idClient Id of the client
     * @param name Name of the client
     * @param address Address of the client
     * @param email Email of the client
     * @param age Age of the client
     */
    public Client(int idClient, String name, String address, String email, int age) {
        this.idClient = idClient;
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public Client(String name, String address, String email, int age) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public Client() {

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client [" + "id=" + idClient + ", name='" + name  + ", adress='" + address + ", email='" + email  + ", age=" + age + ']';
    }
}
