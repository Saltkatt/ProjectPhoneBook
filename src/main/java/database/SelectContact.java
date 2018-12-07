package database;

/**
 * This class selects contacts from the database
 * @author Elin Sexton
 */

public class SelectContact {

    /**
     * Selects a contact from the database
     * @param name of the contact
     * @param number of the contact
     */

    public void selectContact(String name, String number) {

        String selectNameSQL = "SELECT " + name + " FROM phone_book;";
        String selectNumberSQL = "SELECT " + number + " FROM phone_book;";
        String selectAllSQL = "SELECT * FROM phone_book;";

    }


}
