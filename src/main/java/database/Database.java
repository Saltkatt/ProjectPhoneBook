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

    private String fileName;
    private AddContact addContact;
    private RemoveContact removeContact;
    private UpdateContact updateContact;
    private SelectContact selectContact;
    
    /**
     * Having instances of all the smaller classes that works with the database here ensures that the right instance of a
     * database is updated when a method is used by referring to its name.
     *
     * @param fileName the name of the database that will be created
     */
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
    private void setupDatabase(){

        String sql = "CREATE TABLE IF NOT EXISTS contacts (\n"
                + " contact_id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL CHECK (length(number) > 0 AND length(name) < 26),\n"
                + "	number TEXT NOT NULL CHECK (length(number) > 0 AND length(number) < 21)\n"
                + ");";


        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fileName)) {
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public AddContact getAddContact() {
        return addContact;
    }

    public RemoveContact getRemoveContact() {
        return removeContact;
    }

    public UpdateContact getUpdateContact() {
        return updateContact;
    }

    public SelectContact getSelectContact() {
        return selectContact;
    }
}
