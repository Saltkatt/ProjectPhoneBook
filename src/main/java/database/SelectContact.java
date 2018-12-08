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

    /**
     * Selects a contact based on the input name.
     * @param name of the contact.
     */
    public void selectNameContact(String name){

        String selectName = "SELECT contact_id, name, number FROM phone_book WHERE name= ?";

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db");
             PreparedStatement pstmt  = con.prepareStatement(selectName)){
            pstmt.setString(1,name);
            ResultSet rs  = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("contact_id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("number"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Selects a contact based on the input number.
     * @param number of the contact.
     */
    public void selectNumberContact(String number){

        String selectNumber = "SELECT contact_id, name, number FROM phone_book WHERE number= ?";

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db");
             PreparedStatement pstmt  = con.prepareStatement(selectNumber)){
            pstmt.setString(1,number);
            ResultSet rs  = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("contact_id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("number"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
