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
 * This class tests the SelectContact class.
 * 
 * @author Elin Sexton
 */
class SelectContactTest {

    private Database db;

    /**
     * Create testing database.
     */

    @BeforeAll
    void setupDatabase() {
        db = new Database("database_testing_select");

        db.getAddContact().addContact("Anton", "0107433221");
        db.getAddContact().addContact("Bertil", "0206122334");
        db.getAddContact().addContact("Carl", "0305564738");
        db.getAddContact().addContact("Daniella", "0404659301");
        db.getAddContact().addContact("Elin", "0509384929");

    }

    /**
     * Tests for selecting all, name and number.
     * SelectContact sends information to an ArrayList and therefore needs a toString to find contacts.
     * When testing selectAll it is expected that all contacts in the list are found.
     */

    @Test
    void testSelectAll() {

        assertEquals(db.getSelectContact().selectAllContact().toString(),
                "[1\tAnton\t0107433221, " +
                "2\tBertil\t0206122334, " +
                "3\tCarl\t0305564738, " +
                "4\tDaniella\t0404659301, " +
                "5\tElin\t0509384929]");

    }

    /**
     * Tests that the selected name produces the correct contact or contacts in the list.
     * When testing selectName it is expected that the name selected matches the correct contact.
     */
    @Test
    void testSelectName() {

        assertEquals(db.getSelectContact().selectNameContact("Daniella").toString(),"[4\tDaniella\t0404659301]");

    }

    /**
     * Tests that the selected number produces the correct contact in the list.
     * When testing selectNumber it is expected that the number selected matches the correct contact.
     */
    @Test
    void testSelectNumber() {

        assertEquals(db.getSelectContact().selectNumberContact("0206122334").toString(),"[2\tBertil\t0206122334]");

    }

    /**
     *  Removes testing database after the tests have run.
     */
    @AfterAll
    void removeDatabase(){
        try {
            Files.deleteIfExists(Paths.get("database_testing_select"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
