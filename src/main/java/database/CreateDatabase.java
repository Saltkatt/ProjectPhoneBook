package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class set up the database and the tables in it
 * @author Ida
 */
public class CreateDatabase {

    /**
     * Checks if the database exists. If it doesn't, it creates it.
     */
    public void createDatabaseIfNotExist(){

        String sql = "CREATE TABLE phone_book (\n"
                + " contact_id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL CHECK (length(name) < 25),\n"
                + "	number TEXT NOT NULL CHECK (length(number) > 8 AND length(number) < 15)\n"
                + ");";


        if(!new File("C:/sqlite/db/phone_book.db").isFile()){
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/phone_book.db")) {
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
