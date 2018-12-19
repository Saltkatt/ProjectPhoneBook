package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class tests that creating a database actually creates the file and with the right name. More in depth tests
 * for insert, delete, update and select of the table can be found in the respective test class.
 *
 * @author Ida
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatabaseTest {

    /**
     * Creates a database.
     */
    @BeforeAll
    void setupDatabase(){
        new Database("database_test.db");
    }

    /**
     * Tests that the database file got created in the current directory and with the chosen name.
     */
    @Test
    void testThatTheCreatedDatabaseExistsAndWithTheRightName(){
        assertTrue(Files.exists(Paths.get("database_test.db")));
    }

    /**
     * Deletes the database so every time this test class runs it setup a new one which assures an old database can't
     * cause bugs which makes the test more reliable.
     */
    @AfterAll
    void removeDatabaseSoTheTestsAlwaysRunWithANewOne(){
        try {
            Files.deleteIfExists(Paths.get("database_test.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
