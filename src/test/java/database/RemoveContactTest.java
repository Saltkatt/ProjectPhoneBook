package database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class RemoveContactTest {

    private Database db;
    @BeforeAll
    void setupDatabase() {
        db = new Database("database_testing_remove");
        //database to check updates against.
        try {
            db.getAddContact().addContact("Anton", "0107433221");
            db.getAddContact().addContact("Bertil", "0206122334");
            db.getAddContact().addContact("Carl", "0305564738");
            db.getAddContact().addContact("Daniella", "0404659301");
            db.getAddContact().addContact("Elin", "0509384929");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Test removeContact.
     */

    @Test
    void testRemove() {

    }

}
