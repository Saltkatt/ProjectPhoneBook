package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddContactTest {

    @BeforeAll
    void createDatabaseConnection(){
        //new Database().setupDatabase("phone_book_test.db");
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
    void closeDatabaseConnection(){

    }
}
