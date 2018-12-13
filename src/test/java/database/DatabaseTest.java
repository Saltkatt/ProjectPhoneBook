package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatabaseTest {

    private Database db;

    @BeforeAll
    void setupDatabase(){
        db = new Database("database_test.db");
    }

    @Test
    void testThatTheCreatedDatabaseExistsAndWithTheRightName(){
        assertTrue(Files.exists(Paths.get("database_test.db")));
    }

    @AfterAll
    void removeDatabaseSoTheTestsAlwaysRunWithANewOne(){
        try {
            Files.deleteIfExists(Paths.get("database_test.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
