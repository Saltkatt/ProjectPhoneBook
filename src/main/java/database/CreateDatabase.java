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

    static String saveDir = System.getProperty("user.home") + File.separator + "IdeaProjects" + File.separator +
            "ProjectPhoneBook" + File.separator;

    /**
     * Creates a database in the default project path. If the user have a different path than the default,
     * it creates the directories before creating the databasefile. If it needs to create a path it's platform independent.
     */
    public void createDatabaseIfNotExist(){

        String sql = "CREATE TABLE IF NOT EXISTS contacts (\n"
                + " contact_id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL CHECK (length(name) < 25),\n"
                + "	number TEXT NOT NULL CHECK (length(number) > 0 AND length(number) < 21)\n"
                + ");";


        new File(saveDir).mkdirs();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + saveDir + "phone_book.db")) {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
