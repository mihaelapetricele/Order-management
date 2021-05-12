package ro.tuc.tp.bll;

import ro.tuc.tp.bll.validators.OrderValidator;
import ro.tuc.tp.dao.OrderTableDAO;
import ro.tuc.tp.model.Client;
import ro.tuc.tp.model.OrderTable;
import ro.tuc.tp.model.Product;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class that made the bond between OrderTableDAO class and OrderController class
 * @author Petricele Mihaela
 */


public class OrderTableBLL {
    OrderTableDAO orderDAO = new OrderTableDAO();

    public int insertOrder(OrderTable order) {
        JPanel panel = new JPanel();
        ProductBLL productBLL = new ProductBLL();
        ClientBLL clientBLL = new ClientBLL();
        Product product = productBLL.findByIdProdus(order.getIdProduct());
        Client client = clientBLL.findClientById(order.getIdClient());
        if (OrderValidator.validate(order)) {
            product.setCantitate(product.getCantitate() - order.getCantitate());
            productBLL.updateProduct(product);
            return orderDAO.insert(order);
        }
        return 0;
    }

    public List<OrderTable> findAllOrder() {
        return orderDAO.findAll();
    }

    public OrderTable findOrderById(int id)
    {
        return orderDAO.findById(id);
    }

    public void bill(OrderTable orderTable, int idOrder) {
        try {
            File myFile = new File("bill" + idOrder + orderTable.getIdClient() + orderTable.getIdProduct() + ".txt");
            FileWriter myWriter = new FileWriter("bill" + idOrder + orderTable.getIdClient() + orderTable.getIdProduct() + ".txt");

            ClientBLL clientBLL = new ClientBLL();
            ProductBLL productBLL = new ProductBLL();
            Client client = clientBLL.findClientById(orderTable.getIdClient());
            Product product = productBLL.findByIdProdus(orderTable.getIdProduct());
            myWriter.write("  The Bill            \n");
            myWriter.write("  Client details\n" + "Id Client: " + orderTable.getIdClient() + "\nName: " + client.getName() + "\nAdress: " + client.getAddress() + "\nEmail: " + client.getEmail() + "\nAge: " + client.getAge() + "\n");
            myWriter.write("  Product details\n" + "Id Product: " + orderTable.getIdProduct() + "\nName: " + product.getNume() + "\nQuantity: " + orderTable.getCantitate() + "\nPrice: " + product.getPret() + "\n");
            myWriter.write("  TOTAL price is: " + orderTable.getCantitate() * product.getPret());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
