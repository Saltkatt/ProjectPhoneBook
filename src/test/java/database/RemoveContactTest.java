package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

/**
 * This test class tests the RemoveContact class.
 *
 * @author Elin Sexton
 */
class RemoveContactTest {

    private Database db;

    /**
     * Creates a testing database.
     */
    @BeforeAll
    void setupDatabase() {
        db = new Database("database_testing_remove");

        db.getAddContact().addContact("Anton", "0107433221");
        db.getAddContact().addContact("Bertil", "0206122334");
        db.getAddContact().addContact("Carl", "0305564738");
        db.getAddContact().addContact("Daniella", "0404659301");
        db.getAddContact().addContact("Elin", "0509384929");

    }

    /**
     * Test removeContact:
     * Removes one contact (2. Bertil) is removed from the list by checking the size of the list.
     * When testing removeContact it is expected that the contact_id chosen is removed from the list
     * and that the list size reflects the new amount of contacts.
     */

    @Test
    void testRemoveOne() {

        db.getRemoveContact().removeContact(2);
        assertEquals(db.getSelectContact().selectAllContact().size(), 4);

    }

    /**
     * Removes the testing database after tests.
     */
    @AfterAll
    void removeDatabase(){
        try {
            Files.deleteIfExists(Paths.get("database_testing_remove"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
