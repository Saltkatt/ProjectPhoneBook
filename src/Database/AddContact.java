package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddContact {

    public void addContact(String name, String number) {
        String sql = "INSERT INTO phone_book(name,number) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, number);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
