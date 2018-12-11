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
     * Creates a database in the same directory as where the project is saved
     */
    public void createDatabaseIfNotExist(){

        String sql = "CREATE TABLE IF NOT EXISTS contacts (\n"
                + " contact_id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL CHECK (length(name) < 25),\n"
                + "	number TEXT NOT NULL CHECK (length(number) > 0 AND length(number) < 21)\n"
                + ");";


        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:phone_book.db")) {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
