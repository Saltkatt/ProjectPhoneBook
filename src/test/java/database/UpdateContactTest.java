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
class UpdateContactTest {

    private Database db;
    @BeforeAll
    void setupDatabase() {
        db = new Database("database_testing_update");
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
     * Tests for updating name and number.
     */
    @Test
    void testUpdateName() {

        db.getUpdateContact().updateName(0,"Solveig");
        assertEquals(db.getSelectContact().selectAllContact().get(0),"1	Solveig	0107433221");

    }

    @Test
    void testUpdateNumber() {

    }

    //removes testing database after the tests.
    @AfterAll
    void removeDatabase(){
        try {
            Files.deleteIfExists(Paths.get("database_testing_update"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
