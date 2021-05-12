package ro.tuc.tp.model;

/**
 * Class that name is exact as the table <i>Product</i> from database, and which has the exact same fields
 * @author Petricele Mihaela
 */
public class Product {
    private int idProduct;
    private String nume;
    private int cantitate;
    private float pret;

    /**
     * Constructor with parameters of the Product Class
     * @param idProduct Id of the product
     * @param nume Name of the product
     * @param cantitate The amount of the product that is available
     * @param pret Price of the product
     */
    public Product(int idProduct, String nume, int cantitate, float pret) {
        this.idProduct = idProduct;
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
    }
    public Product(String nume, int cantitate, float pret) {
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
    }
    public Product()
    {

    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }
}
