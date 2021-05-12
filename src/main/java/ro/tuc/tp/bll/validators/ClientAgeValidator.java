package ro.tuc.tp.bll.validators;

import ro.tuc.tp.model.Client;

import javax.swing.*;

/**
 * Class that implements the Validator interface and validate the age of the Client
 * @author Petricele Mihaela
 */


public class ClientAgeValidator implements Validator<Client> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 70;
    final JPanel panel = new JPanel();
    public boolean validate(Client valid) {

        if (valid.getAge() < MIN_AGE || valid.getAge() > MAX_AGE) {
            JOptionPane.showMessageDialog(panel, "Varsta trebuie sa fie cuprinsa intre 7 si 70 de ani!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
