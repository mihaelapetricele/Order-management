package ro.tuc.tp.presentation.View;


import ro.tuc.tp.bll.OrderTableBLL;
import ro.tuc.tp.presentation.TableView;
import ro.tuc.tp.presentation.controller.OrderController;

import javax.swing.*;
import java.awt.*;

/**
 * Class that describe the window interface for Order operations
 * @author Petricele Mihaela
 */


public class OrderPage {
    /**
     * JButton for the Order operation
     */
    JButton comanda = new JButton("ORDER");
    /**
     * JButton for the List of the elements of the table
     */
    JButton listare = new JButton("LIST");
    JLabel titlu = new JLabel("ORDER TABLE");
    JLabel idClient = new JLabel("ID client: ");
    JLabel idProdus = new JLabel("ID produs: ");
    JLabel cantitate = new JLabel("Cantitate: ");
    /**
     * JTextField for the IdProduct field
     */
    JTextField idProductInserare = new JTextField(10);
    /**
     * JTextField for the IdClient field
     */
    JTextField idClientInserare = new JTextField(10);
    /**
     * JTextField for the cantitate field
     */
    JTextField cantitateInserare = new JTextField(10);
    /**
     * JTable for the list of Client
     */
    JTable afisareDateOrder = new JTable();

    JFrame frame1 = new JFrame("Order Page");
    JPanel panelTable = new JPanel();
    JPanel management1 = new JPanel();

    OrderController orderController = new OrderController(this);

    public OrderPage() {
        afisareTabel();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900, 350);
        OrderTableBLL orderTableBLL = new OrderTableBLL();

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panelTable = new JPanel();

        panel.add(titlu);
        titlu.setFont(new Font("Serif", Font.BOLD, 24));
        panel.setBackground(new Color(255, 255, 230));
        panel.setMaximumSize(new Dimension(900, 50));

        panel1.add(idClient);
        panel1.add(idClientInserare);
        panel1.setMaximumSize(new Dimension(900, 30));
        panel1.setBackground(new Color(255, 215, 210));

        panel2.add(idProdus);
        panel2.add(idProductInserare);
        panel2.setMaximumSize(new Dimension(900, 30));
        panel2.setBackground(new Color(255, 215, 210));

        panel4.add(cantitate);
        panel4.add(cantitateInserare);
        panel4.setMaximumSize(new Dimension(900, 30));
        panel4.setBackground(new Color(255, 215, 210));

        panel3.add(comanda);
        comanda.setSize(10, 50);
        comanda.addActionListener(orderController);
        panel3.add(listare);
        listare.setSize(50, 20);
        listare.addActionListener(orderController);
        panel3.setMaximumSize(new Dimension(900, 40));
        panel3.setBackground(new Color(255, 255, 230));

        afisareDateOrder.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(afisareDateOrder);
        panelTable.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(730,120));
        panelTable.setMaximumSize(new Dimension(900,150));
        panelTable.setBackground(new Color(255,255,230));


        JPanel management1 = new JPanel();
        management1.add(panel);
        management1.add(panel2);
        management1.add(panel1);
        management1.add(panel4);
        management1.add(panel3);
        management1.add(panelTable);

        management1.setLayout(new BoxLayout(management1, BoxLayout.Y_AXIS));
        frame1.setContentPane(management1);
        frame1.setVisible(true);
    }

    /**
     * Method that show the clients in the JTable and update the JTable after each operations
     */

    public void afisareTabel() {
        afisareDateOrder.setVisible(false);
        OrderTableBLL orderTableBLL = new OrderTableBLL();
        afisareDateOrder.setModel(TableView.retrieveProperties(orderTableBLL.findAllOrder()));
        afisareDateOrder.setVisible(true);
    }

    public JButton getComanda() {
        return comanda;
    }

    public JButton getListare() {
        return listare;
    }

    public JLabel getIdClient() {
        return idClient;
    }

    public void setIdClient(JLabel idClient) {
        this.idClient = idClient;
    }

    public JLabel getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(JLabel idProdus) {
        this.idProdus = idProdus;
    }

    public JLabel getCantitate() {
        return cantitate;
    }

    public void setCantitate(JLabel cantitate) {
        this.cantitate = cantitate;
    }

    public JTextField getIdProductInserare() {
        return idProductInserare;
    }

    public void setIdProductInserare(JTextField idProductInserare) {
        this.idProductInserare = idProductInserare;
    }

    public JTextField getIdClientInserare() {
        return idClientInserare;
    }

    public void setIdClientInserare(JTextField idOrderInserare) {
        this.idClientInserare = idClientInserare;
    }

    public JTextField getCantitateInserare() {
        return cantitateInserare;
    }

    public void setCantitateInserare(JTextField cantitateInserare) {
        this.cantitateInserare = cantitateInserare;
    }

    public JTable getAfisareDateOrder() {
        return afisareDateOrder;
    }

    public void setAfisareDateOrder(JTable afisareDateOrder) {
        this.afisareDateOrder = afisareDateOrder;
    }

}