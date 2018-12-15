package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class selects contacts from the database.
 * @author Elin Sexton
 */

public class SelectContact {

    private String fileName;

    public SelectContact(String fileName){
        this.fileName = fileName;
    }

    /**
     * Selects all contacts from the database and prints the list.
     */
    public List<String> selectAllContact() {

        //SQL-statement to select all from table contacts.
        String selectAll = "SELECT * FROM contacts";

        //Create list contacts.
        List<String> contacts = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(selectAll)){

                //Adds contact_id, name and number to the list contacts.
                while (rs.next()) {
                    contacts.add(rs.getInt("contact_id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("number"));
                }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contacts;
    }

    /**
     * Selects a contact based on the input name.
     * @param name of the contact.
     */
    public List<String> selectNameContact(String name){

        //SQL-statement selects contact based on name.
        String selectName = "SELECT contact_id, name, number FROM contacts WHERE name LIKE ?";

        //Create list contactName.
        List<String> contactName = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + fileName);
             PreparedStatement pstmt  = con.prepareStatement(selectName)){
            pstmt.setString(1,"%" + name + "%");
            ResultSet rs  = pstmt.executeQuery();

            ////Adds contact_id, name and number to the list contactName.
            while (rs.next()) {
                contactName.add(rs.getInt("contact_id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("number"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contactName;
    }

    /**
     * Selects a contact based on the input number.
     * @param number of the contact.
     */
    public List<String> selectNumberContact(String number){

        //SQL-statement selects contact based on number.
        String selectNumber = "SELECT contact_id, name, number FROM contacts WHERE number LIKE ?";

        //Create list contactNumber.
        List<String> contactNumber = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:sqlite:" + fileName);
             PreparedStatement pstmt  = con.prepareStatement(selectNumber)){
            pstmt.setString(1,"%" + number + "%");
            ResultSet rs  = pstmt.executeQuery();

            ////Adds contact_id, name and number to the list contactNumber.
            while (rs.next()) {
                contactNumber.add (rs.getInt("contact_id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("number"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return contactNumber;
    }
}
