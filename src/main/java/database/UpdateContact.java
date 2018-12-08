package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateContact {

    /**
     * Updates a selected statement.
     * @param name of the contact.
     * @param number of the contact.
     */

    public void updateContact(int contact_id, String name, String number) {

        String updateName = "UPDATE phone_book SET name=" +name+ "WHERE contact_id=" +contact_id;
        String updateNumber = "UPDATE phone_book SET number=" +number+ "WHERE contact_id=" +contact_id;


        try (Connection con = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db");
             PreparedStatement pstmt = con.prepareStatement(updateName)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, contact_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }










    }

}
