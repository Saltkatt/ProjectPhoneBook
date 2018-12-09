package userinteraction;

import database.AddContact;
import database.RemoveContact;
import database.SelectContact;
import database.UpdateContact;

import java.util.List;

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
        UserOutput.printLine("Enter name:");
        String name = UserInput.name();

        UserOutput.printLine("Enter phone number:");
        String phoneNumber = UserInput.phoneNumber();

        addContact.addContact(name, phoneNumber);
    }

    /**
     * Searching for contacts by name and returning the chosen contacts id.
     */
    public int searchByName() {
        UserOutput.printLine("Enter name:");
        String name = UserInput.name();
        String contact = chooseContactFromList(SelectContact.selectContact(name, ""));
        return Integer.parseInt(contact.substring(0, contact.indexOf(' ')));
    }

    /**
     * Searching for contacts by phone number and returning the chosen contacts id.
     */
    public int searchByPhoneNumber() {
        UserOutput.printLine("Enter phone number:");
        String phoneNumber = UserInput.phoneNumber();
        return chooseContactFromList(SelectContact.selectContact("", phoneNumber));
    }

    /**
     * Letting user choose contact from a list and returning its id.
     */
    public int chooseContactFromList(List<String> contacts) {
        for(int i = 0; i < contacts.size(); i++) {
            UserOutput.printLine(i + 1 + ". " + contacts.get(i).substring(contacts.indexOf(" ") + 1));
        }
        String contact = contacts.get(UserInput.chooseFromList(contacts));
        return Integer.parseInt(contact.substring(0, contact.indexOf(" ")));
    }

    /**
     * Providing database update name method with a contact id, belonging to the contact to update, and the new name.
     */
    public void updateName(int contactID) {
        UserOutput.printLine("Enter new name:");
        String name = UserInput.name();

        updateContact.updateName(contactID, name);
    }

    /**
     * Providing database update phone number method with a contact id, belonging to the contact to update,
     * and the new phone number.
     */
    public void updatePhoneNumber(int contactID) {
        UserOutput.printLine("Enter new phone number:");
        String phoneNumber = UserInput.phoneNumber();

        updateContact.updatePhoneNumber(contactID, phoneNumber);
    }

    /**
     * Providing database removal method with a contact id, belonging to the contact to remove.
     */
    public void remove(int contactID) {
        removeContact.removeContact(contactID);
    }
}
