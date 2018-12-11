package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddContactTest {

    private Database db;

    @BeforeAll
    void setupTestDatabase(){
        db = new Database("insert_test.db");
        db.setupDatabase();
    }

    @Test
    void testIfPossibleToInsertValuesThatDoesntAlreadyExistInTable(){

    }

    @Test
    void testIfPossibleToInsertValuesThatAlreadyExistInTable(){

    }

    @Test
    void testThatValuesCantBeNull(){


    }

    @Test
    void testThatStringValuesCantBeEmpty(){

    }

    @AfterAll
    static void removeTestDatabase(){
        try {
            Files.deleteIfExists(Paths.get("insert_test.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
