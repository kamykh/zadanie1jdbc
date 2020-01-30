package pl.edu.wszib.shop;

import pl.edu.wszib.shop.dbConnector.DBConnector;
import pl.edu.wszib.shop.models.Product;

import static pl.edu.wszib.shop.GUI.GUI.showMenu;

public class App {
    public static void main(String[] args) {

        DBConnector.connect();

        //---------------check
        //Product product = new Product(8,"marlboro","other",340);
       // DBConnector.addProduct(product);
       // System.out.println("sth happened " + product.getId());

        //DBConnector.showContent();

        //DBConnector.showByAmountLowerThan(100);
        //DBConnector.showWhatsSold();
        //DBConnector.showProducers();
        showMenu();
    }
}
