package ro.tuc.tp.bll;

import ro.tuc.tp.bll.validators.ClientAgeValidator;
import ro.tuc.tp.bll.validators.EmailValidator;
import ro.tuc.tp.bll.validators.Validator;
import ro.tuc.tp.dao.ClientDAO;
import ro.tuc.tp.model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class that made the bond between ClientDAO class and ClientController class
 * @author Petricele Mihaela
 */

public class ClientBLL {
    private List<Validator<Client>> validators;
    ClientDAO clientDAO = new ClientDAO();
    final JPanel panel = new JPanel();

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());

    }
    public Client findClientById(int id) {
        Client st = clientDAO.findById(id);
        if (st == null) {
            JOptionPane.showMessageDialog(panel, "Clientul nu exista!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return st;
    }

    public List<Client> findAllClient()
    {
        return clientDAO.findAll();
    }

    public int deleteClient(int id) {

        return clientDAO.delete(id);
    }

    public int insertClient(Client client){
            for (Validator<Client> v : validators) {
                    v.validate(client);
            }

        return clientDAO.insert(client);
    }

    public int updateClient(Client client)
    {
        return clientDAO.update(client, client.getIdClient());
    }

}
