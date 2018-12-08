package database;

import java.sql.*;

/**
 * This class selects contacts from the database
 * @author Elin Sexton
 */

public class SelectContact {

    /**
     * Selects all contacts from the database and prints the list.
     */

    public void selectAllContact() {

        String selectAll = "SELECT * FROM phone_book";

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db");
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(selectAll)){

                while (rs.next()) {
                    System.out.println(rs.getInt("contact_id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("number"));
                }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
