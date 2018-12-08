package database;

public class UpdateContact {

    /**
     * Updates a selected statement.
     * @param name of the contact.
     * @param number of the contact.
     */

    public void updateContact(int contact_id, String name, String number) {

        String updateName = "UPDATE phone_book SET name=" +name+ "WHERE contact_id=" +contact_id;
        String updateNumber = "UPDATE phone_book SET number=" +number+ "WHERE contact_id=" +contact_id;






    }

}
