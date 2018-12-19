package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class updates contacts in the database.
 *
 * @author Elin Sexton
 */

public class UpdateContact {



    private String fileName;

    /**
     * Constructor.
     *
     * @param fileName of the database.
     */

    public UpdateContact(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Updates the name of the contact selected via SQL-statement.
     * if-statement ensures that name input falls within parameters.
     *
     * @param contact_id of the contact.
     * @param name of the contact.
     */

    public void updateName(int contact_id, String name) {

        if (name != null && name.matches("^[a-zåäöA-ZÅÄÖ]{1,30}$")) {
            //SQL-statement updates contact name.
            String updateName = "UPDATE contacts SET name= ? WHERE contact_id= ?";


            try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 PreparedStatement pstmt = con.prepareStatement(updateName)) {
                pstmt.setString(1, name);
                pstmt.setInt(2, contact_id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Updates the number of the contact selected via SQL-statement.
     * if-statement ensures that number input falls within parameters.
     *
     * @param contact_id of the contact.
     * @param number     of the contact.
     */
    public void updatePhoneNumber(int contact_id, String number) {

        if (number != null && number.matches("^[0-9]{1,20}$")) {
            //SQL-statement updates contact number.
            String updatePhoneNumber = "UPDATE contacts SET number= ? WHERE contact_id= ?";

            try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                 PreparedStatement pstmt = con.prepareStatement(updatePhoneNumber)) {
                pstmt.setString(1, number);
                pstmt.setInt(2, contact_id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

}
