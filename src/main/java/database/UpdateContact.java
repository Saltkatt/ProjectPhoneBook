package database;

public class UpdateContact {

    /**
     * Updates a selected statement.
     * @param name of the contact.
     * @param number of the contact.
     */

    public void updateStatement(String name, String number) {

        String updateNameSQL = "UPDATE name FROM phone_book WHERE name=" + name + ";";
        String updateNumberSQL = "UPDATE number FROM phone_book WHERE number=" + number + ";";

    }

}
