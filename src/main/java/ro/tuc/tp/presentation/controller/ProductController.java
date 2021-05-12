package ro.tuc.tp.presentation.controller;

import ro.tuc.tp.bll.ProductBLL;
import ro.tuc.tp.model.Product;
import ro.tuc.tp.presentation.View.OrderPage;
import ro.tuc.tp.presentation.View.ProductPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class which implements ActionListener and the specific method and extract the data from the Product window interface
 * @author Petricele Mihaela
 */


public class ProductController implements ActionListener {
    public final ProductPage productPage;

    public ProductController(ProductPage productPage) {
        this.productPage = productPage;
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (productPage.getInserare() != null) {
            if (src == productPage.getInserare()) {
                String nume = productPage.getNumeInserare().getText();
                int cantitate = Integer.parseInt(productPage.getCantitateInserare().getText());
                float pret = Float.parseFloat(productPage.getPretInserare().getText());
                ProductBLL productBLL = new ProductBLL();
                Product product = new Product(nume, cantitate, pret);
                assert false;
                productBLL.insertProduct(product);
                productPage.afisareTabel();
            }
        }
        if (src == productPage.getActualizare()) {
            int id = Integer.parseInt(productPage.getIdUpdate().getText());
            String nume = productPage.getNumeUpdate().getText();
            int cantitate = Integer.parseInt(productPage.getCantitateUpdate().getText());
            float pret = Float.parseFloat(productPage.getPretlUpdate().getText());
            ProductBLL productBLL = new ProductBLL();
            Product product = new Product(id, nume, cantitate, pret);
            productBLL.updateProduct(product);
            productPage.afisareTabel();
        }
        if (src == productPage.getStergere()) {
            int id = Integer.parseInt(productPage.getIdDelete().getText());
            ProductBLL productBLL = new ProductBLL();
            assert false;
            productBLL.deleteProduct(id);
            productPage.afisareTabel();
        }
        if (src == productPage.getList()) {
            productPage.afisareTabel();
        }
    }
}
