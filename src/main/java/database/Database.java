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
public class Database {

    //TODO remove public access?
    private String fileName;
    public AddContact addContact;
    public RemoveContact removeContact;
    public UpdateContact updateContact;
    public SelectContact selectContact;

    public Database(String fileName){
        this.fileName = fileName;
        addContact = new AddContact(fileName);
        removeContact = new RemoveContact(fileName);
        updateContact = new UpdateContact(fileName);
        selectContact = new SelectContact(fileName);
        setupDatabase();
    }

    /**
     * Creates a database in the same directory as where the project is saved
     */
    public void setupDatabase(){

        String sql = "CREATE TABLE IF NOT EXISTS contacts (\n"
                + " contact_id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL CHECK (length(name) < 25),\n"
                + "	number TEXT NOT NULL CHECK (length(number) > 0 AND length(number) < 21)\n"
                + ");";


        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fileName)) {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
