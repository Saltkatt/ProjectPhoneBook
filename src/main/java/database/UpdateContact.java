package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateContact {

    /**
     * Updates a selected statement.
     * @param contact_id of the contact.
     * @param name of the contact.
     */

    public void updateName(int contact_id, String name) {

        String updateName = "UPDATE phone_book SET name= ? WHERE contact_id= ?";

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + CreateDatabase.saveDir + "phone_book.db");
             PreparedStatement pstmt = con.prepareStatement(updateName)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePhoneNumber(int contact_id, String number) {

        String updatePhoneNumber = "UPDATE phone_book SET number= ? WHERE contact_id= ?";
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + CreateDatabase.saveDir + "phone_book.db");
             PreparedStatement pstmt = con.prepareStatement(updatePhoneNumber)) {
            pstmt.setString(1, number);
            pstmt.setInt(2, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }











    }

}
