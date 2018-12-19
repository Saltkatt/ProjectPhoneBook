package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class removes a contact from the database using the contact_id.
 *
 * @author Elin Sexton
 */

public class RemoveContact {

    private String fileName;

    /**
     * Constructor allowing connection to Database.
     *
     * @param fileName of the database.
     */

    public RemoveContact(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Deletes an existing contact from the database via SQL-statement.
     *
     * @param contact_id of the contact.
     */

    public void removeContact(int contact_id) {
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
