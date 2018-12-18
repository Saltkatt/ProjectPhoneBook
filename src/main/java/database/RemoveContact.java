package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class removes a row from the database using the contact_id.
 * @author Elin Sexton
 */

public class RemoveContact {
    /**
     * Deletes an existing contact from the database.
     * @param contact_id of the contact.
     */

    private String fileName;

    public RemoveContact(String fileName){
        this.fileName = fileName;
    }

    public void removeContact(int contact_id){
        //String SQL-statement to delete contact.
        String removeSQL = "DELETE FROM contacts WHERE contact_id= ?";

        //Connects to the database and deletes received contact_id.
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + fileName);
             PreparedStatement pstmt = con.prepareStatement(removeSQL)) {
            pstmt.setInt(1, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
