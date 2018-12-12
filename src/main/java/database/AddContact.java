package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class manages adding new contacts to the database
 * @author Ida
 */
public class AddContact {

    private String fileName;

    public AddContact(String fileName){
        this.fileName = fileName;
    }

    /**
     * Inserts a new contact to the database
     * @param name the name of the contact
     * @param number the number of the contact
     */
    public void addContact(String name, String number) throws SQLException{
        String sql = "INSERT INTO contacts(name,number) VALUES(?,?)";

        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.executeUpdate();
        } catch (SQLException e){
            throw new SQLException();
        }
    }
}
