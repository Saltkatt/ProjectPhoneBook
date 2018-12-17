package conversion;

import database.Database;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is testing the ArrayToObservable-class
 * It is only really to be used in the context of JavaFX and SelectContact-classmethods
 *
 * @author Daniella Norén
 * @version 1 Build 2018
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArrayToObservableTest {

    Database db;

    /**
     * Set up a temporary database for the test, add contacts to the database
     */
    @BeforeAll
    void setUp(){
        db = new Database("arrayToObservableTest");
        db.getAddContact().addContact("Daniella", "0768982776");
        db.getAddContact().addContact("Bosse", "123456789");
        db.getAddContact().addContact("Frott", "4534576345");
    }

    /**
     * Test so that the list from SelectContact creates
     * an ObservableList full of Contacts.
     */
    @Test
    void toContactObservable() {
        List<String> list = db.getSelectContact().selectAllContact();
        ObservableList<Contact> contacts = ArrayToObservable.toContactObservable(list);
        assertEquals("Daniella", contacts.get(0).getName());
        assertEquals("Bosse", contacts.get(1).getName());
        assertEquals("Frott", contacts.get(2).getName());
        assertEquals(list.size(), contacts.size());
        assertEquals("4534576345", contacts.get(2).getNumber());
    }

    /**
     * Check so that if given an incorrectly formated List<String>,
     * the methods returns an empty ObservableList
     */
    @Test
    void notSelectContactList(){
        List<String> list = new ArrayList<>();
        list.add("Hello there");
        list.add("wow");
        ObservableList<Contact> contacts = ArrayToObservable.toContactObservable(list);
        assertEquals(0, contacts.size());

    }

    /**
     * Delete the database
     */
    @AfterAll
    void tearDown(){
        try {
            Files.deleteIfExists(Paths.get("arrayToObservableTest"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}