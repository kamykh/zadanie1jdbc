package pl.edu.wszib.shop.GUI;

import java.util.Scanner;

import static pl.edu.wszib.shop.dbConnector.DBConnector.*;

public class GUI {
    public static void showMenu(){
        //metoda statyczna (nie potrzeba tworzyc obiektu, mozna sie zawsze odwolac)
        System.out.println("Type number of desired action: ");
        System.out.println("1. Show products");
        System.out.println("2. Buy product");
        System.out.println("3. Show amount in category");
        System.out.println("4. Show available producers");
        System.out.println("5. Quit");

        Scanner scanner = new Scanner(System.in);
        String linia = scanner.nextLine();

        byte var3 = -1;

        switch(linia.hashCode()) {
            case 49:
                if (linia.equals("1")) {
                    var3 = 0;
                }
                break;
            case 50:
                if (linia.equals("2")) {
                    var3 = 1;
                }
                break;
            case 51:
                if (linia.equals("3")) {
                    var3 = 2;
                }
                break;
            case 52:
                if (linia.equals("4")){
                    var3 = 3;
                }
            case 53:
                if(linia.equals("5")){
                    var3 = 4;
                }

        }

        switch(var3){
            case 0:
                showContent();
                showMenu();
                break;
            case 1:

                System.out.println("Podaj id: ");
                linia = scanner.nextLine();
                int id = Integer.parseInt(linia);
                System.out.println("Podaj ilosc: ");
                linia = scanner.nextLine();
                int amount = Integer.parseInt(linia);

                buy(id,amount);
                System.out.println("Kupiono " + amount + " produktow o id = " + id);
                showMenu();
                break;

            case 2:

                showAmountsInCategories();
                showMenu();
                break;

            case 3:

                showProducers();
                showMenu();
                break;

            case 4:

                break;

            default:

                showMenu();

        }
    }
}
