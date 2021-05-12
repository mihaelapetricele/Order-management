package ro.tuc.tp.presentation.controller;

import ro.tuc.tp.bll.ClientBLL;
import ro.tuc.tp.bll.OrderTableBLL;
import ro.tuc.tp.bll.ProductBLL;
import ro.tuc.tp.model.Client;
import ro.tuc.tp.model.OrderTable;
import ro.tuc.tp.model.Product;
import ro.tuc.tp.presentation.View.OrderPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Class which implements ActionListener and the specific method and extract the data from the OrderTable window interface
 *
 * @author Petricele Mihaela
 */


public class OrderController implements ActionListener {
    public final OrderPage orderPage;

    public OrderController(OrderPage orderPage) {
        this.orderPage = orderPage;
    }

    public JPanel panel = new JPanel();
    ProductBLL productBLL = new ProductBLL();

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == orderPage.getComanda()) {
            try {
            int idClient = Integer.parseInt(orderPage.getIdClientInserare().getText());
            int idProdus = Integer.parseInt(orderPage.getIdProductInserare().getText());
            int cantitate = Integer.parseInt(orderPage.getCantitateInserare().getText());
            Product product = productBLL.findByIdProdus(idProdus);
            float price = product.getPret() * cantitate;
            OrderTable order = new OrderTable(idClient, idProdus, cantitate, price);
            OrderTableBLL orderBLL = new OrderTableBLL();
            orderBLL.insertOrder(order);
            int id;
            id = (int) (1 + (Math.random() * (100 - 1)));
            orderBLL.bill(order, id);
            orderPage.afisareTabel();
            }catch (IndexOutOfBoundsException exception)
            {
                JOptionPane.showMessageDialog(panel, "Produsul/clientul introdus nu exista!\nIntroduceti alt produs/client!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (src == orderPage.getListare()) {
            orderPage.afisareTabel();
        }
    }
}
