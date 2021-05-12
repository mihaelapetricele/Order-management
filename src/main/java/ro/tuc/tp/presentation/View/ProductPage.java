package ro.tuc.tp.presentation.View;

import ro.tuc.tp.bll.ProductBLL;
import ro.tuc.tp.presentation.TableView;
import ro.tuc.tp.presentation.controller.ProductController;

import javax.swing.*;
import java.awt.*;

/**
 * Class that describe the window interface for Product operations
 * @author Petricele Mihaela
 */


public class ProductPage {
    /**
     * JButton for the Insert operation
     */
    JButton inserare = new JButton("INSERT");
    /**
     * JButton for the Delete operation
     */
    JButton stergere = new JButton("DELETE");
    /**
     * JButton for the Update operation
     */
    JButton actualizare = new JButton("UPDATE");
    /**
     * JButton for the List of the elements of the table
     */
    JButton list = new JButton("LIST");
    JLabel titlu = new JLabel("PRODUCT TABLE");
    JLabel inserareText = new JLabel("INSERT PRODUCT");
    JLabel updateText= new JLabel("UPDATE PRODUCT");
    JLabel deleteText= new JLabel("DELETE PRODUCT");
    JLabel numeTextInserare = new JLabel("Nume produs: ");
    JLabel numeTextUpdate = new JLabel("Nume produs: ");
    JLabel cantitateTextInserare = new JLabel("Cantitate: ");
    JLabel cantitateTextUpdate = new JLabel("Cantitate: ");
    JLabel pretTextInserare = new JLabel("Pret: ");
    JLabel pretTextUpdate = new JLabel("Pret: ");
    JLabel idTextUpdate = new JLabel("ID produs: ");
    JLabel idTextDelete = new JLabel("ID produs: ");
    /**
     * JTextField for the field nume
     */
    JTextField numeInserare = new JTextField(10);
    JTextField numeUpdate = new JTextField(10);
    /**
     * JTextField for the field cantitate
     */
    JTextField cantitateInserare = new JTextField(10);
    JTextField cantitateUpdate = new JTextField(10);
    /**
     * JTextField for the field price
     */
    JTextField pretInserare = new JTextField(15);
    JTextField pretlUpdate = new JTextField(15);
    /**
     * JTextField for the field Id
     */
    JTextField idUpdate = new JTextField(5);
    JTextField idDelete = new JTextField(5);
    /**
     * JTable for the list of Client
     */
    JTable afisareDateProdus = new JTable(5,5);
    JFrame frame1 = new JFrame("Product Page");
    JPanel panelTable = new JPanel();
    JPanel management1 = new JPanel();


    ProductController productController = new ProductController(this);

    public ProductPage()
    {
        afisareTabel();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(900,600);

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();

        panel.add(titlu);
        titlu.setFont(new Font("Serif",Font.BOLD,24));
        //panel.setMaximumSize(new Dimension(600,100));
        panel.setBackground(new Color(255,215,210));

        panel.setMaximumSize(new Dimension(900,50));

        panel2.add(inserareText);
        inserareText.setFont(new Font("Serif",Font.ITALIC,16));
        panel2.setMaximumSize(new Dimension(900,35));
        panel2.setBackground(new Color(255,255,240));
        panel2.setBackground(new Color(255,215,210));
        panel1.add(numeTextInserare);
        panel1.add(numeInserare);
        panel1.add(cantitateTextInserare);
        panel1.add(cantitateInserare);
        panel1.add(pretTextInserare);
        panel1.add(pretInserare);
        panel1.setMaximumSize(new Dimension(900,50));
        panel1.setBackground(new Color(255,255,240));
        panel3.add(inserare);
        inserare.addActionListener(productController);
        panel3.setMaximumSize(new Dimension(900,50));
        panel3.setBackground(new Color(255,255,240));

        panel4.add(updateText);
        updateText.setFont(new Font("Serif",Font.ITALIC,16));
        panel4.setMaximumSize(new Dimension(900,30));
        panel4.setBackground(new Color(255,215,210));
        panel5.add(idTextUpdate);
        panel5.add(idUpdate);
        panel5.add(numeTextUpdate);
        panel5.add(numeUpdate);
        panel5.add(cantitateTextUpdate);
        panel5.add(cantitateUpdate);
        panel5.add(pretTextUpdate);
        panel5.add(pretlUpdate);
        panel5.setMaximumSize(new Dimension(900,40));
        panel5.setBackground(new Color(255,255,240));
        panel6.add(actualizare);
        actualizare.addActionListener(productController);
        panel6.setMaximumSize(new Dimension(900,50));
        panel6.setBackground(new Color(255,255,240));

        panel7.add(deleteText);
        deleteText.setFont(new Font("Serif",Font.ITALIC,16));
        panel7.setMaximumSize(new Dimension(900,35));
        panel7.setBackground(new Color(255,215,210));
        panel8.add(idTextDelete);
        panel8.add(idDelete);
        panel8.setMaximumSize(new Dimension(900,40));
        panel8.setBackground(new Color(255,255,240));
        panel9.add(stergere);
        stergere.addActionListener(productController);
        panel9.setMaximumSize(new Dimension(900,50));
        panel9.setBackground(new Color(255,255,240));
        panel10.add(list);
        list.addActionListener(productController);
        panel10.setMaximumSize(new Dimension(900,50));
        panel10.setBackground(new Color(255,255,240));

        afisareDateProdus.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(afisareDateProdus);
        panelTable.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(730,120));
        panelTable.setMaximumSize(new Dimension(900,150));
        panelTable.setBackground(new Color(255,255,240));

        management1.add(panel);
        management1.add(panel2);
        management1.add(panel1);
        management1.add(panel3);
        management1.add(panel4);
        management1.add(panel5);
        management1.add(panel6);
        management1.add(panel7);
        management1.add(panel8);
        management1.add(panel9);
        management1.add(panel10);
        management1.add(panelTable);

        management1.setLayout(new BoxLayout(management1, BoxLayout.Y_AXIS));
        frame1.setContentPane(management1);
        frame1.setVisible(true);
    }

    /**
     * Method that show the clients in the JTable and update the JTable after each operations
     */

    public void afisareTabel() {
        afisareDateProdus.setVisible(false);
        ProductBLL productBLL = new ProductBLL();
        afisareDateProdus.setModel(TableView.retrieveProperties(productBLL.findAllProduct()));
        afisareDateProdus.setVisible(true);
    }

    public JButton getInserare() {
        return inserare;
    }

    public JButton getStergere() {
        return stergere;
    }

    public JButton getActualizare() {
        return actualizare;
    }

    public JLabel getInserareText() {
        return inserareText;
    }

    public JLabel getUpdateText() {
        return updateText;
    }

    public JLabel getDeleteText() {
        return deleteText;
    }

    public JLabel getNumeTextInserare() {
        return numeTextInserare;
    }

    public JLabel getNumeTextUpdate() {
        return numeTextUpdate;
    }

    public JLabel getCantitateTextInserare() {
        return cantitateTextInserare;
    }

    public JLabel getCantitateTextUpdate() {
        return cantitateTextUpdate;
    }

    public JLabel getPretTextInserare() {
        return pretTextInserare;
    }

    public JLabel getPretTextUpdate() {
        return pretTextUpdate;
    }

    public JLabel getIdTextUpdate() {
        return idTextUpdate;
    }

    public JLabel getIdTextDelete() {
        return idTextDelete;
    }

    public JTextField getNumeInserare() {
        return numeInserare;
    }

    public JTextField getNumeUpdate() {
        return numeUpdate;
    }

    public JTextField getCantitateInserare() {
        return cantitateInserare;
    }

    public JTextField getCantitateUpdate() {
        return cantitateUpdate;
    }

    public JTextField getPretInserare() {
        return pretInserare;
    }

    public JTextField getPretlUpdate() {
        return pretlUpdate;
    }

    public JTextField getIdUpdate() {
        return idUpdate;
    }

    public JTextField getIdDelete() {
        return idDelete;
    }

    public JTable getAfisareDateProdus() {
        return afisareDateProdus;
    }

    public void setAfisareDateProdus(JTable afisareDateProdus) {
        this.afisareDateProdus = afisareDateProdus;
    }

    public JButton getList() {
        return list;
    }

    public void setList(JButton list) {
        this.list = list;
    }
}
