package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

class RemoveContactTest {

    private Database db;
    @BeforeAll
    void setupDatabase() {
        db = new Database("database_testing_remove");
        //database to check updates against.
        try {
            db.getAddContact().addContact("Anton", "0107433221");
            db.getAddContact().addContact("Bertil", "0206122334");
            db.getAddContact().addContact("Carl", "0305564738");
            db.getAddContact().addContact("Daniella", "0404659301");
            db.getAddContact().addContact("Elin", "0509384929");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test removeContact.
     */

    @Test
    void testRemove() {

    }

    //removes the testing database after tests.
    @AfterAll
    void removeDatabase(){
        try {
            Files.deleteIfExists(Paths.get("database_testing_remove"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
