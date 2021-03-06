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
 * This class tests the updateContact methods.
 * @author Elin Sexton
 */
class UpdateContactTest {

    private Database db;

    /**
     * Creates testing database.
     */

    @BeforeAll
    void setupDatabase() {
        db = new Database("database_testing_update");

        db.getAddContact().addContact("Anton", "0107433221");
        db.getAddContact().addContact("Bertil", "0206122334");
        db.getAddContact().addContact("Carl", "0305564738");
        db.getAddContact().addContact("Daniella", "0404659301");
        db.getAddContact().addContact("Elin", "0509384929");
        db.getAddContact().addContact("Arne", "010101010");

    }

    /**
     * Tests that updateName updates the name of the first contact in the database.
     * Updates name of contact Anton to Solveig.
     * SelectContact uses an Arraylist and therefore starts the list at position 0 instead of 1.
     * Therefore we get position 0 instead of 1.
     *
     * When testing updateName it is expected that the new name replaces the name of the correct contact.
     */

    @Test
    void testUpdateName() {

        db.getUpdateContact().updateName(1,"Solveig");
        assertEquals(db.getSelectContact().selectAllContact().get(0),"1	Solveig	0107433221");

    }

    /**
     * Tests that updatePhoneNumber updates the number of the third contact in the database.
     * Updates phone number of contact.
     * SelectContact uses an arraylist and therefore starts the list at position 0 instead of 1.
     * Therefore we get position 2 for Carl instead of 3.
     *
     * When testing updateNumber it is expected that the new number replaces the number of the correct contact.
     */

    @Test
    void testUpdateNumber() {

        db.getUpdateContact().updatePhoneNumber(3,"1234567890");
        assertEquals(db.getSelectContact().selectAllContact().get(2),"3\tCarl\t1234567890");

    }

    /**
     * Tests that the name updated cannot be null.
     *
     * When testing updateNameCantBeNull it is expected that the null value not replace the current contact name.
     */

    @Test
    void testUpdateNameCantBeNull() {

        db.getUpdateContact().updateName(4, null);
        assertEquals(db.getSelectContact().selectAllContact().get(3), "4\tDaniella\t0404659301");
    }

    /**
     * Tests that the number updated cannot be null.
     *
     * When testing updateNumberCantBeNull it is expected that the null value not replace the current contact number.
     */

    @Test
    void testUpdateNumberCantBeNull() {

        db.getUpdateContact().updatePhoneNumber(5, null);
        assertEquals(db.getSelectContact().selectAllContact().get(4), "5\tElin\t0509384929");

    }

    /**
     * Tests that name cannot be updated with digits.
     *
     * When testing updateNameCantBeNumber it is expected that the name value cannot be replaced by digits.
     */

    @Test
    void testUpdateNameCantBeDigits() {

        db.getUpdateContact().updateName(2, "1234");
        assertEquals(db.getSelectContact().selectAllContact().get(1), "2\tBertil\t0206122334");
    }

    /**
     * Tests that number cannot be updated with letters.
     *
     * When testing updateNumberCantBeLetters it is expected that the number value cannot be replaced with letters.
     */

    @Test
    void testUpdateNumberCantBeLetters() {

        db.getUpdateContact().updatePhoneNumber(6, "phoneNumber");
        assertEquals(db.getSelectContact().selectAllContact().get(5),"6\tArne\t010101010");
    }


    /**
     * Removes testing database after the tests.
     */
    @AfterAll
    void removeDatabase(){
        try {
            Files.deleteIfExists(Paths.get("database_testing_update"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
