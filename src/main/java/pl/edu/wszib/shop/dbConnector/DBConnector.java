package pl.edu.wszib.shop.dbConnector;

import pl.edu.wszib.shop.models.Product;

import java.sql.*;

public class DBConnector {
    public static Connection connection = null;

    public static void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            DBConnector.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/shop?user=root&password=");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(Product product) {

        String sql = "INSERT INTO products (id, producer, category, amount) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getProducer());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setInt(4, product.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public static void showContent() {
        try {
            String sql = "SELECT * from products";

            Statement smt = connection.createStatement();
            ResultSet rs = smt.executeQuery(sql);

            if (rs.next()) {
                do {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                } while (rs.next());
            } else {
                System.out.println("Nothin here !?");
            }

        } catch (Exception e) {
            System.out.println("sth went wrong");
        }


    }

    public static void showByAmountLowerThan(int amount) {
        try {
            String sql = "SELECT * from products WHERE amount < " + amount;

            Statement smt = connection.createStatement();
            ResultSet rs = smt.executeQuery(sql);

            if (rs.next()) {
                do {
                    System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                } while (rs.next());
            } else {
                System.out.println("Nothin here !?");
            }

        } catch (Exception e) {
            System.out.println("sth went wrong");
        }


    }

    public static void showWhatsSold() {
        showByAmountLowerThan(1);
    }

    public static void buy(int id, int amount) {
        try {
            String sql = "UPDATE products SET amount = amount - " + amount + "  WHERE id = " + id + " AND amount > " + amount;
            String sql1 = "SELECT * FROM products WHERE id = " + id + " AND amount > " + amount;

            Statement smt = connection.createStatement();
            ResultSet rs = smt.executeQuery(sql1);

            if (rs.next()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
            } else {
                System.out.println("Brak produktu bądź błedne id");
            }


        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
            System.out.println("buy went wrong");
        }

    }

    public static void showAmountsInCategories() {
        try {
            String sql = "SELECT category, amount FROM products GROUP BY category";

            Statement smt = connection.createStatement();
            ResultSet rs = smt.executeQuery(sql);

            if (rs.next()) {
                do {
                    System.out.println(rs.getString(1) + " " + rs.getInt(2));
                } while (rs.next());
            } else {
                System.out.println("Nothin here !?");
            }

        } catch (Exception e) {
            System.out.println("sth went wrong");
        }


    }

    public static void showProducers() {
        try {
            String sql = "SELECT DISTINCT producer FROM products";

            Statement smt = connection.createStatement();
            ResultSet rs = smt.executeQuery(sql);

            if (rs.next()) {
                do {
                    System.out.println(rs.getString(1));
                } while (rs.next());
            } else {
                System.out.println("Nothin here !?");
            }

        } catch (Exception e) {
            System.out.println("sth went wrong");
        }


    }

}

