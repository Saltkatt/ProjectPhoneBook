package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateContact {

    /**
     * Updates the name of the row selected.
     * @param contact_id of the contact.
     * @param name of the contact.
     */

    public void updateName(int contact_id, String name) {

        String updateName = "UPDATE contacts SET name= ? WHERE contact_id= ?";

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:phone_book.db");
             PreparedStatement pstmt = con.prepareStatement(updateName)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates the number of the contact selected.
     * @param contact_id of the contact.
     * @param number of the contact.
     */
    public void updatePhoneNumber(int contact_id, String number) {

        String updatePhoneNumber = "UPDATE contacts SET number= ? WHERE contact_id= ?";
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:phone_book.db");
             PreparedStatement pstmt = con.prepareStatement(updatePhoneNumber)) {
            pstmt.setString(1, number);
            pstmt.setInt(2, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }











    }

}
