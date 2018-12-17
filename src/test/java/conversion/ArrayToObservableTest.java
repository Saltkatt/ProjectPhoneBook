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
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArrayToObservableTest {

    Database db;

    @BeforeAll
    void setUp(){
        db = new Database("arrayToObservableTest");
        db.getAddContact().addContact("Daniella", "0768982776");
        db.getAddContact().addContact("Bosse", "123456789");
        db.getAddContact().addContact("Frott", "4534576345");
    }

    @Test
    void toContactObservable() {
        List<String> list = db.getSelectContact().selectAllContact();
        ObservableList<Contact> contacts = ArrayToObservable.toContactObservable(list);
        assertEquals("Daniella", contacts.get(0).getName());
        assertEquals("Bosse", contacts.get(1).getName());
        assertEquals("Frott", contacts.get(2).getName());
        assertEquals(list.size(), contacts.size());
        assertEquals("4534576345", contacts.get(2).getNumber());
        assertEquals(1, contacts.get(0).getContactID());
    }

    @Test
    void notSelectContactList(){
        List<String> list = new ArrayList<>();
        list.add("Hello there");
        list.add("wow");
        ObservableList<Contact> contacts = ArrayToObservable.toContactObservable(list);
        assertEquals(0, contacts.size());

    }
    @AfterAll
    void tearDown(){
        try {
            Files.deleteIfExists(Paths.get("arrayToObservableTest"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}