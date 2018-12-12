package database;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddContactTest {

    Database db;

    @BeforeAll
    void setupDatabase(){
        db = new Database("database_test_insert.db");
    }

    @Test
    void testThatValuesCantBeNull(){
        assertThrows(SQLException.class, () -> db.addContact.addContact(null, null));
    }


    @Test
    void testThatStringValuesCantBeEmpty(){
        assertThrows(SQLException.class, () -> db.addContact.addContact("", ""));
    }

    @Test
    void testIfPossibleToInsertValuesThatDoesntAlreadyExistInTable(){
        try {
            db.addContact.addContact("Bob", "123");
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testIfPossibleToInsertValuesThatAlreadyExistInTable(){
        try{
            db.addContact.addContact("TheSuperCreativeName", "123321");
            db.addContact.addContact("TheSuperCreativeName", "123321");
        } catch (SQLException e){
            fail(e.getMessage());
        }
    }
//
//    
//
//    @Test
//    void testThatCharactersCantExceedMaxLimit(){
//        Database db = new Database("insert_test5.db");
//
//        db.addContact.addContact("aaaaaaaaaaaaaaaaaaaaaaaaa", "1111111111111111111111111111");
//        db.addContact.addContact("aaaaaaaaaaaaaaaaaaaaaaaa", "111111111111111111111111111111");
//        db.addContact.addContact("aaaaaaaaaaaaaaaaaaaaaaaaa", "111111111111111111111111111");
//        db.addContact.addContact("aaaaaaaaaaaaaaaaaaaaaaaa", "1111111111111111111111111111");
//
//        assertEquals(1, db.selectContact.selectAllContact().size());
//
//        try {
//            Files.deleteIfExists(Paths.get("insert_test5.db"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void testThatPhoneNumberOnlyCanContainNumbers(){
//        Database db = new Database("insert_test6.db");
//
//        try {
//            Files.deleteIfExists(Paths.get("insert_test6.db"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    @AfterAll
    void removeDatabaseSoTheTestAlwaysRunWithANewOne(){
        try {
            Files.deleteIfExists(Paths.get("database_test_insert.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
