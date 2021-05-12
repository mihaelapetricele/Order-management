package ro.tuc.tp.presentation.controller;

import ro.tuc.tp.bll.ClientBLL;
import ro.tuc.tp.model.Client;
import ro.tuc.tp.presentation.View.ClientPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class which implements ActionListener and the specific method and extract the data from the Client window interface
 * @author Petricele Mihaela
 */

public class ClientController implements ActionListener {

    public final ClientPage clientPage;

    public ClientController(ClientPage clientPage) {
        this.clientPage = clientPage;
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        assert false;
        if (src == clientPage.getInserare()) {
            String nume = clientPage.getNumeInserare().getText();
            String adresa = clientPage.getAdresaInserare().getText();
            String email = clientPage.getEmailInserare().getText();
            int age = Integer.parseInt(clientPage.getAgeInserare().getText());
            ClientBLL clientBLL = new ClientBLL();
            Client client = new Client(nume, adresa, email, age);
            clientBLL.insertClient(client);
            clientPage.afisareTabel();
        }

        if (src == clientPage.getActualizare()) {
            int id = Integer.parseInt(clientPage.getIdUpdate().getText());
            String nume = clientPage.getNumeUpdate().getText();
            String adresa = clientPage.getAdresaUpdate().getText();
            String email = clientPage.getEmailUpdate().getText();
            int age = Integer.parseInt(clientPage.getAgeUpdate().getText());
            ClientBLL clientBLL = new ClientBLL();
            Client client = new Client(id, nume, adresa, email, age);
            clientBLL.updateClient(client);
            clientPage.afisareTabel();
        }
        if (clientPage.getStergere() != null) {
            if (src == clientPage.getStergere()) {
                int id = Integer.parseInt(clientPage.getIdDelete().getText());
                ClientBLL clientBLL = new ClientBLL();
                assert false;
                clientBLL.deleteClient(id);
                clientPage.afisareTabel();
            }
        }

      if(src == clientPage.getList())
      {
          clientPage.afisareTabel();
      }
    }

}
