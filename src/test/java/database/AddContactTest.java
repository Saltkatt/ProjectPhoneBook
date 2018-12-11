package database;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;


class AddContactTest {

    @Test
    void testThatValuesCantBeNull(){

        Database db = new Database("insert_test1.db");

        db.addContact.addContact(null, null);
        assertEquals(0, db.selectContact.selectAllContact().size());

        try {
            Files.deleteIfExists(Paths.get("insert_test1.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testThatStringValuesCantBeEmpty(){
        Database db = new Database("insert_test2.db");

        db.addContact.addContact("", "");
        assertEquals(0, db.selectContact.selectAllContact().size());

        try {
            Files.deleteIfExists(Paths.get("insert_test2.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testIfPossibleToInsertValuesThatDoesntAlreadyExistInTable(){

        Database db = new Database("insert_test3.db");
        db.addContact.addContact("Bob", "123");

        assertEquals(db.selectContact.selectAllContact().get(0).replaceAll("\\s+",""), "1Bob123");

        try {
            Files.deleteIfExists(Paths.get("insert_test3.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testIfPossibleToInsertValuesThatAlreadyExistInTable(){

        Database db = new Database("insert_test4.db");

        db.addContact.addContact("Bob", "123");
        db.addContact.addContact("Bob", "123");

        assertEquals(2, db.selectContact.selectAllContact().size());

        try {
            Files.deleteIfExists(Paths.get("insert_test4.db"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
