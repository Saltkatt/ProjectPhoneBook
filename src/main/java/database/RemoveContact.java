package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class removes a row from the database using the contact_id.
 * @author Elin
 */

public class RemoveContact {
    /**
     * Deletes an existing contact from the database.
     * @param contact_id of the contact.
     */
    public void removeContact(int contact_id){
        //String SQL-statement to delete contact.
        String removeSQL = "DELETE FROM phone_book WHERE contact_id=" + contact_id + ";";

        //Connects to the database and deletes received id.
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db");
             PreparedStatement pstmt = con.prepareStatement(removeSQL)) {
            pstmt.setInt(1, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
