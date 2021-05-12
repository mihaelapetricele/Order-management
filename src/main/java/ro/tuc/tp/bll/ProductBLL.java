package ro.tuc.tp.bll;

import ro.tuc.tp.dao.ProductDAO;
import ro.tuc.tp.model.Product;

import javax.swing.*;
import java.util.List;

/**
 * Class that made the bond between ProductDAO class and ProductController class
 * @author Petricele Mihaela
 */


public class ProductBLL {
    ProductDAO productDAO = new ProductDAO();
    JPanel panel = new JPanel();

    public int insertProduct(Product product)
    {
        return productDAO.insert(product);
    }

    public int deleteProduct(int idProdus)
    {
        return productDAO.delete(idProdus);
    }

    public int updateProduct(Product product)
    {
        return productDAO.update(product, product.getIdProduct());
    }

    public Product findByIdProdus(int id)
    {
        Product product = productDAO.findById(id);
        if(product == null)
        {
            JOptionPane.showMessageDialog(panel, "Produsul nu exista!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return product;
    }

    public List<Product> findAllProduct()
    {
        return productDAO.findAll();
    }
}
