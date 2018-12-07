package main.java.userinteraction;

import database.AddContact;
import database.RemoveContact;
import database.UpdateContact;

public class ContactManager {

    /**
     * This class manages the user interactions which concern creating new and editing existing contacts.
     */

    private database.AddContact addContact;
    private database.RemoveContact removeContact;
    private database.UpdateContact updateContact;

    public ContactManager(AddContact addContact, RemoveContact removeContact, UpdateContact updateContact) {
        this.addContact = addContact;
        this.removeContact = removeContact;
        this.updateContact = updateContact;
    }

    /**
     * Getting info from user for creating a contact and providing the result to database adding method.
     */
    public void create() {
        addContact.addContact(enterName(), enterPhoneNumber());
    }

    /**
     * Providing database update name method with a contact id, belonging to the contact to update, and the new name.
     */
    public void updateName(int contactID) {
        updateContact.updateName(contactID, enterName());
    }

    /**
     * Providing database update phone number method with a contact id, belonging to the contact to update,
     * and the new phone number.
     */
    public void updateName(int contactID) {
        updateContact.updateName(contactID, enterName());
    }

    /**
     * Providing database removal method with a contact id, belonging to the contact to remove.
     */
    public void remove(int contactID) {
        removeContact.removeContact(contactID);
    }

    /**
     * Collect name input from user and return it
     */
    public String enterName() {
        UserOutput.printLine("Enter name:");
        return UserInput.name();
    }

    /**
     * Collect phone number input from user and return it
     */
    public String enterPhoneNumber() {
        UserOutput.printLine("Enter phone number:");
        return UserInput.phoneNumber();
    }

}