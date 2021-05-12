package ro.tuc.tp.presentation.View;

import ro.tuc.tp.bll.ClientBLL;
import ro.tuc.tp.presentation.TableView;
import ro.tuc.tp.presentation.controller.ClientController;
import javax.swing.*;
import java.awt.*;

/**
 * Class that describe the window interface for Client operations
 * @author Petricele Mihaela
 */

public class ClientPage extends JFrame{
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
    JLabel titlu = new JLabel("CLIENT TABLE");
    JLabel inserareText = new JLabel("INSERT CLIENT");
    JLabel updateText= new JLabel("UPDATE CLIENT");
    JLabel deleteText= new JLabel("DELETE CLIENT");
    JLabel numeTextInserare = new JLabel("Name: ");
    JLabel numeTextUpdate = new JLabel("Name: ");
    JLabel adresaTextInserare = new JLabel("Address: ");
    JLabel adresaTextUpdate = new JLabel("Address: ");
    JLabel emailTextInserare = new JLabel("Email: ");
    JLabel emailTextUpdate = new JLabel("Email: ");
    JLabel ageTextInserare = new JLabel("Age: ");
    JLabel ageTextUpdate = new JLabel("Age: ");
    JLabel idTextUpdate = new JLabel("ID client: ");
    JLabel idTextDelete = new JLabel("ID client: ");
    /**
     * JTextField for the field nume
     */
    JTextField numeInserare = new JTextField(10);
    JTextField numeUpdate = new JTextField(10);
    /**
     * JTextField for the field address
     */
    JTextField adresaInserare = new JTextField(10);
    JTextField adresaUpdate = new JTextField(10);
    /**
     * JTextField for the field email
     */
    JTextField emailInserare = new JTextField(15);
    JTextField emailUpdate = new JTextField(15);
    /**
     * JTextField for the field age
     */
    JTextField ageInserare = new JTextField(10);
    JTextField ageUpdate = new JTextField(10);
    /**
     * JTextField for the field Id
     */
    JTextField idUpdate = new JTextField(5);
    JTextField idDelete = new JTextField(5);
    /**
     * JTable for the list of Client
     */
    JTable afisareDateClient = new JTable();

    JFrame frame1 = new JFrame("Client Page");
    JPanel panelTable = new JPanel();
    JPanel management1 = new JPanel();
    ClientController clientController = new ClientController(this);

    public ClientPage()
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
        panel1.add(adresaTextInserare);
        panel1.add(adresaInserare);
        panel1.add(emailTextInserare);
        panel1.add(emailInserare);
        panel1.add(ageTextInserare);
        panel1.add(ageInserare);
        panel1.setMaximumSize(new Dimension(900,50));
        panel1.setBackground(new Color(255,255,240));
        panel3.add(inserare);
        inserare.addActionListener(clientController);
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
        panel5.add(adresaTextUpdate);
        panel5.add(adresaUpdate);
        panel5.add(emailTextUpdate);
        panel5.add(emailUpdate);
        panel5.add(ageTextUpdate);
        panel5.add(ageUpdate);
        panel5.setMaximumSize(new Dimension(900,40));
        panel5.setBackground(new Color(255,255,240));
        panel6.add(actualizare);
        actualizare.addActionListener(clientController);
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
        stergere.addActionListener(clientController);
        panel9.setMaximumSize(new Dimension(900,50));
        panel9.setBackground(new Color(255,255,240));
        panel10.add(list);
        list.addActionListener(clientController);
        panel10.setMaximumSize(new Dimension(900,50));
        panel10.setBackground(new Color(255,255,240));

        afisareDateClient.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(afisareDateClient);
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
        afisareDateClient.setVisible(false);
        ClientBLL clientBLL = new ClientBLL();
        afisareDateClient.setModel(TableView.retrieveProperties(clientBLL.findAllClient()));
        afisareDateClient.setVisible(true);
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

    public JTable getAfisareDateClient() {
        return afisareDateClient;
    }

    public void setAfisareDateClient(JTable afisareDateClient) {
        this.afisareDateClient = afisareDateClient;
    }

    public JTextField getNumeInserare() {
        return numeInserare;
    }

    public JTextField getNumeUpdate() {
        return numeUpdate;
    }

    public JTextField getAdresaInserare() {
        return adresaInserare;
    }

    public JTextField getAdresaUpdate() {
        return adresaUpdate;
    }

    public JTextField getEmailInserare() {
        return emailInserare;
    }

    public JTextField getEmailUpdate() {
        return emailUpdate;
    }

    public JTextField getAgeInserare() {
        return ageInserare;
    }

    public JTextField getAgeUpdate() {
        return ageUpdate;
    }

    public JTextField getIdUpdate() {
        return idUpdate;
    }

    public JTextField getIdDelete() {
        return idDelete;
    }

    public JButton getList() {
        return list;
    }

    public void setList(JButton list) {
        this.list = list;
    }

}
