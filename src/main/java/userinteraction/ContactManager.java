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
    private database.SelectContact selectContact;

    public ContactManager(AddContact addContact, RemoveContact removeContact, UpdateContact updateContact, SelectContact selectContact) {
        this.addContact = addContact;
        this.removeContact = removeContact;
        this.updateContact = updateContact;
        this.selectContact = selectContact;
    }

    /**
     * Getting info from user for creating a contact and providing the result to database adding method.
     */
    public void create() {
        String name = enterName("Enter name");
        String phoneNumber = enterPhoneNumber("Enter phone number");
        addContact.addContact(name, phoneNumber);
    }

    /**
     * Providing database removal method with a contact id, belonging to the contact to remove.
     */
    public void remove(int contactID) {
        removeContact.removeContact(contactID);
    }

    /**
     * Providing database update name method with a contact id, belonging to the contact to update, and the new name.
     */
    public void updateName(int contactID) {
        String name = enterName("Enter new name");
        updateContact.updateName(contactID, name);
    }

    /**
     * Providing database update phone number method with a contact id, belonging to the contact to update,
     * and the new phone number.
     */
    public void updatePhoneNumber(int contactID) {
        String phoneNumber = enterPhoneNumber("Enter new phone number");
        updateContact.updatePhoneNumber(contactID, phoneNumber);
    }

    /**
     * Letting user enter a name and returns it.
     */
    private String enterName(String headLine) {
        UserOutput.printLine(headLine);
        return UserInput.name();
    }

    /**
     * Letting user enter a phone number and returns it.
     */
    private String enterPhoneNumber(String headLine) {
        UserOutput.printLine(headLine);
        return UserInput.phoneNumber();
    }

    /**
     * Picking from full contact list and returning the chosen contacts id.
     */
    public int findByList() {
        return chooseContactFromList(selectContact.selectAllContacts());
    }

    /**
     * Searching for contacts by name and returning the chosen contacts id.
     */
    public int searchByName() {
        String name = enterName("Enter name search phrase");
        return chooseContactFromList(selectContact.selectContact(name, ""));
    }

    /**
     * Searching for contacts by phone number and returning the chosen contacts id.
     */
    public int searchByPhoneNumber() {
        String phoneNumber = enterPhoneNumber("Enter phone number search phrase");
        return chooseContactFromList(selectContact.selectContact("", phoneNumber));
    }

    /**
     * Letting user choose contact from a list and returning its id.
     */
    private int chooseContactFromList(List<String> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            UserOutput.printLine(i + 1 + ". " + contacts.get(i).substring(contacts.indexOf(" ") + 1));
        }
        String contact = contacts.get(UserInput.chooseFromList(contacts));
        return Integer.parseInt(contact.substring(0, contact.indexOf(" ")));
    }
}
