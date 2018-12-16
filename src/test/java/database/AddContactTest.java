package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddContactTest {


    @Test
    void testThatValuesCantBeNull(){
        Database db1 = new Database("test_insert1.db");
        db1.getAddContact().addContact(null, null);
        assertEquals(db1.getSelectContact().selectAllContact().size(), 0);
    }


    @Test
    void testThatStringValuesCantBeEmpty(){
        Database db2 = new Database("test_insert2.db");
        db2.getAddContact().addContact("", "");
        assertEquals(db2.getSelectContact().selectAllContact().size(), 0);
    }


    //TODO fix sql syntax so this test works
    @Test
    void testThatNameOnlyAcceptLettersAndNumberOnlyAcceptNumbers(){
        Database db3 = new Database("test_insert3.db");
        db3.getAddContact().addContact("abc", "123");
        db3.getAddContact().addContact("123", "abc");
        db3.getAddContact().addContact("abc", "abc");
        db3.getAddContact().addContact("123", "123");
        assertEquals(db3.getSelectContact().selectAllContact().size(), 1);
    }


    @Test
    void testThatCharactersCantExceedMaxLimit(){
        Database db4 = new Database("test_insert4.db");
        db4.getAddContact().addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ,"11111111111111111111");
        db4.getAddContact().addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ,"11111111111111111111");
        db4.getAddContact().addContact("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ,"111111111111111111111");
        assertEquals(db4.getSelectContact().selectAllContact().size(), 1);
    }


    @Test
    void testIfPossibleToInsertValidValuesThatDoesntAlreadyExistInTable(){
        Database db5 = new Database("test_insert5.db");
        db5.getAddContact().addContact("Bob", "123");
        assertEquals(db5.getSelectContact().selectAllContact().size(), 1);
    }

    @Test
    void testIfPossibleToInsertValidValuesThatAlreadyExistInTable(){
        Database db6 = new Database("test_insert6.db");
        db6.getAddContact().addContact("Bob", "123");
        db6.getAddContact().addContact("Bob", "123");
        assertEquals(db6.getSelectContact().selectAllContact().size(), 2);
    }


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
