package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import model.Menu;

public class DBConnection {

    public boolean insertNewMenu(Menu menu) {
        boolean result = false;
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cafe",
                    "root", "323678@Cc");

            Statement statement;
            statement = connection.createStatement();

                     
            String query = "INSERT INTO menu "
                    + "(name, type, sweetlevel, price) "
                    + "VALUES('"
                    + menu.getName() + "','"
                    + menu.getType() + "','"
                    + menu.getSweetlevel() + "',"
                    + menu.getPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);	// executeUpdate returns row count ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return result;

    }

    /*
    https://www.geeksforgeeks.org/java-database-connectivity-with-mysql/
     */
    public void testRetrieve() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cafe",
                    "root", "323678@Cc");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select name from menu");
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name").trim();
                System.out.println(" name : " + name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

}
