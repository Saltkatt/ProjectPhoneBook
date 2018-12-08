package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class manages adding new contacts to the database
 * @author Ida
 */
public class AddContact {

    /**
     * Inserts a new contact to the database
     * @param name the name of the contact
     * @param number the number of the contact
     */
    public void addContact(String name, String number) {
        String sql = "INSERT INTO contacts(name,number) VALUES(?,?)";

        String saveDir = System.getProperty("user.home") + File.separator + "IdeaProjects" + File.separator +
                "ProjectPhoneBook" + File.separator;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + saveDir + "phone_book.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
