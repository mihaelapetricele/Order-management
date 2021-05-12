package ro.tuc.tp.bll.validators;

/**
 * Interface that implements a method to validate certain object
 * @author Petricele Mihaela
 */


public interface Validator<T> {
    public boolean validate(T valid);
}
