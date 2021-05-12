package ro.tuc.tp.bll.validators;

import ro.tuc.tp.bll.ProductBLL;

import ro.tuc.tp.model.OrderTable;
import ro.tuc.tp.model.Product;

import javax.swing.*;

/**
 * Class that implements Validator interface and validate the product quantity of the Order
 * @author Petricele Mihaela
 */


public class OrderValidator {
    public static boolean validate(OrderTable orderValid){
        ProductBLL productBLL = new ProductBLL();
        final JPanel panel = new JPanel();
        Product product = productBLL.findByIdProdus(orderValid.getIdProduct());
        if (orderValid.getCantitate() > product.getCantitate()) {
            JOptionPane.showMessageDialog(panel, "Cantitatea introdusa este prea mare!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
