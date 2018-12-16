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


    @Test
    void testThatNameOnlyAcceptLetters(){
        Database db3 = new Database("test_insert3.db");
        //todo + fix database sql
    }


    @Test
    void testThatNumberOnlyAcceptNumbers(){
        Database db4 = new Database("test_insert4.db");
        //todo + fix database sql
    }


    @Test
    void testThatCharactersCantExceedMaxLimit(){
        Database db5 = new Database("test_insert5.db");
        //todo + fix database sql bug
    }


    @Test
    void testIfPossibleToInsertValuesThatShouldBeValidThatDoesntAlreadyExistInTable(){
        Database db6 = new Database("test_insert6.db");
        db6.getAddContact().addContact("Bob", "123");
        //todo mooooooore values here
        //assertEquals(db6.getSelectContact().selectAllContact().size(), 1);
    }

    @Test
    void testIfPossibleToInsertValuesThatAlreadyExistInTable(){
        Database db7 = new Database("test_insert7.db");
        db7.getAddContact().addContact("Bob", "123");
        db7.getAddContact().addContact("Bob", "123");
        assertEquals(db7.getSelectContact().selectAllContact().size(), 2);
    }


    @AfterAll
    void removeDatabasesSoTheTestsAlwaysRunWithNewOnes(){
        try {
            for(int i = 1; i <= 7; i++){
                Files.deleteIfExists(Paths.get("test_insert" + i + ".db"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
