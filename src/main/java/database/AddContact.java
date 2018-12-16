package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class manages adding new contacts to the database.
 * @author Ida
 */
public class AddContact {

    private String fileName;

    public AddContact(String fileName){
        this.fileName = fileName;
    }

    /**
     * Inserts a new contact to the database if the arguments are valid.
     *
     * @param name the name of the contact
     * @param number the number of the contact
     */
    public void addContact(String name, String number) {
        if (name != null && number !=null &&
                name.matches("^[a-zA-Z]{1,30}$") && number.matches("^[0-9]{1,20}$")) {
            String sql = "INSERT INTO contacts(name,number) VALUES(?,?)";

            try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fileName);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setString(2, number);
                pstmt.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
