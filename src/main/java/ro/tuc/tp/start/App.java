package ro.tuc.tp.start;


import java.util.logging.Logger;

import ro.tuc.tp.presentation.View.ClientPage;
import ro.tuc.tp.presentation.View.OrderPage;
import ro.tuc.tp.presentation.View.ProductPage;
import ro.tuc.tp.presentation.controller.ClientController;
import ro.tuc.tp.presentation.controller.OrderController;
import ro.tuc.tp.presentation.controller.ProductController;

/**
 * Main class
 * @author Petricele Mihaela
 */
public class App 
{
    protected static final Logger LOGGER = Logger.getLogger(App.class.getName());

    /**
     * Method main that contain the initialization of the windows interfaces
     * @param args of the main method
     */
    public static void main( String[] args )
    {
        ClientPage clientPage = new ClientPage();
        ProductPage productPage = new ProductPage();
        OrderPage orderPage = new OrderPage();
        ClientController clientController = new ClientController(clientPage);
        ProductController productController = new ProductController(productPage);
        OrderController orderController = new OrderController(orderPage);

    }
}
