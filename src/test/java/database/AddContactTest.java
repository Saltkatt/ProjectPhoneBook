package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests that the SQL syntax for insert works as it's expected to when something is added to the database.
 * Each test creates a database instance, insert values that should be tested and then returns the result of whether
 * they got accepted or not.
 *
 * @author Ida
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddContactTest {

    /**
     * Inserts null values to a database and checks that when everything is selected from the database it returns nothing,
     * which means the null constraints works as expected.
     */
    @Test
    void testThatValuesCantBeNull(){
        Database db1 = new Database("test_insert1.db");
        db1.getAddContact().addContact(null, null);
        assertEquals(db1.getSelectContact().selectAllContact().size(), 0);
    }

    /**
     * Inserts empty values to a database and checks that when everything is selected from the database it should
     * return nothing.
     */
    @Test
    void testThatStringValuesCantBeEmpty(){
        Database db2 = new Database("test_insert2.db");
        db2.getAddContact().addContact("", "");
        assertEquals(db2.getSelectContact().selectAllContact().size(), 0);
    }

    /**
     * Tests that the name argument can't contain numbers and that the number argument can't contain letters by
     * inserting all the possible combinations and checking the database only accepted the expected one.
     */
    @Test
    void testThatNameOnlyAcceptLettersAndNumberOnlyAcceptNumbers(){
        Database db3 = new Database("test_insert3.db");
        db3.getAddContact().addContact("123", "abc");
        db3.getAddContact().addContact("abc", "abc");
        db3.getAddContact().addContact("123", "123");
        assertEquals(db3.getSelectContact().selectAllContact().size(), 0);
        db3.getAddContact().addContact("abc", "123");
        assertEquals(db3.getSelectContact().selectAllContact().size(), 1);
    }

    /**
     * Tests that the character limit constraints works by first inserting one character too much than allowed in each
     * argument and see that the list returns nothing and then enter the max amount that is allowed and see that the
     * list returns one.
     */
    @Test
    void testThatCharactersCantExceedMaxLimit(){
        Database db4 = new Database("test_insert4.db");
        db4.getAddContact().addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ,"11111111111111111111");
        db4.getAddContact().addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ,"111111111111111111111");
        assertEquals(db4.getSelectContact().selectAllContact().size(), 0);
        db4.getAddContact().addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ,"11111111111111111111");
        assertEquals(db4.getSelectContact().selectAllContact().size(), 1);
    }

    /**
     * Make sure it works to insert a normal value.
     */
    @Test
    void testIfPossibleToInsertValidValuesThatDoesntAlreadyExistInTable(){
        Database db5 = new Database("test_insert5.db");
        db5.getAddContact().addContact("Bob", "123");
        assertEquals(db5.getSelectContact().selectAllContact().size(), 1);
    }

    /**
     * Make sure that it's possible to insert multiple persons with the same information since different contacts
     * can have the same name or you could want to use the same number on more than one contact.
     */
    @Test
    void testIfPossibleToInsertValidValuesThatAlreadyExistInTable(){
        Database db6 = new Database("test_insert6.db");
        db6.getAddContact().addContact("Bob", "123");
        db6.getAddContact().addContact("Bob", "123");
        assertEquals(db6.getSelectContact().selectAllContact().size(), 2);
    }

    /**
     * Deletes all the test databases so every time this test class runs it setup new ones which assures
     * old databases can't cause bugs and makes the tests more reliable.
     */
    @AfterAll
    void removeDatabasesSoTheTestsAlwaysRunWithNewOnes(){
        try {
            for(int i = 1; i <= 6; i++){
                Files.deleteIfExists(Paths.get("test_insert" + i + ".db"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
