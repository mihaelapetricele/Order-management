package ro.tuc.tp.model;
/**
 * Class that name is exact as the table <i>OrderTable</i> from database, and which has the exact same fields
 * @author Petricele Mihaela
 */
public class OrderTable {
    private int idOrder;
    private int idClient;
    private int idProduct;
    private int cantitate;
    private float price;

    /**
     * Constructor with parameters of the OrderTable Class
     * @param idOrder Id of the order
     * @param idClient Id of the client who order
     * @param idProduct Id of the product
     * @param cantitate The amount of the product which is order
     * @param price Total price of the order
     */
    public OrderTable(int idOrder, int idClient, int idProduct, int cantitate, float price) {
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.cantitate = cantitate;
        this.price = price;
    }

    public OrderTable(int idClient, int idProduct, int cantitate, float price) {
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.cantitate = cantitate;
        this.price = price;
    }

    public OrderTable() {

    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return "" + idOrder + "";
    }
}
