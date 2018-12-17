package userinteraction;

import database.AddContact;
import database.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    public static final String TESTDBNAME = "testDB.db";
    public static final String EMPTYTESTDBNAME = "emptyTestDB.db";

    @BeforeAll
    void setUptestDB() {
        Database testDB = new Database(TESTDBNAME);
        Database emptyTestDB = new Database(EMPTYTESTDBNAME);

        AddContact addToTestDB = new AddContact(TESTDBNAME);
        addToTestDB.addContact("FirstTestContact", "0001");
        addToTestDB.addContact("SecondTestContact", "0002");
    }

    @AfterAll
    void deleteTestDB() {
        File file = new File(TESTDBNAME);
        file.delete();
        file = new File(EMPTYTESTDBNAME);
        file.delete();
    }

    @Test
    void checkIfFindByListReturnsTrueWhenChoosingAContact() {
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        ContactManager cm = new ContactManager(TESTDBNAME);

        assertTrue(cm.findByList());
    }

    @Test
    void checkIfFindByListReturnsFalseWhenChoosingCancel() {
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        ContactManager cm = new ContactManager(TESTDBNAME);

        assertFalse(cm.findByList());
    }

//    @Test
//    void checkIfSearchByNameReturnsTrueWhenChoosingAContact() {
//        System.setIn(new ByteArrayInputStream("First\n1".getBytes()));
//
//        ContactManager cm = new ContactManager(TESTDBNAME);
//
//        assertTrue(cm.searchByName());
//    }
}