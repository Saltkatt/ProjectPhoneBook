package userinteraction;

import database.*;
import java.util.List;

public class ContactManager {

    /**
     * This class manages the user interactions which concern creating new and editing existing contacts.
     */

    private AddContact addContact = new AddContact();
    private RemoveContact removeContact = new RemoveContact();
    private UpdateContact updateContact = new UpdateContact();
    private SelectContact selectContact = new SelectContact();

    private int chosenContactID;

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
    public void remove() {
        removeContact.removeContact(chosenContactID);
    }

    /**
     * Providing database update name method with a contact id, belonging to the contact to update, and the new name.
     */
    public void updateName() {
        String name = enterName("Enter new name");
        updateContact.updateName(chosenContactID, name);
    }

    /**
     * Providing database update phone number method with a contact id, belonging to the contact to update,
     * and the new phone number.
     */
    public void updatePhoneNumber() {
        String phoneNumber = enterPhoneNumber("Enter new phone number");
        updateContact.updatePhoneNumber(chosenContactID, phoneNumber);
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
     * Picking from full contact list and saving the chosen contacts id.
     */
    public boolean findByList() {
        if (chooseContactFromList(selectContact.selectAllContact())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Searching for contacts by name and return if found or not.
     */
    public boolean searchByName() {
        String name = enterName("Enter name search phrase");
        if (chooseContactFromList(selectContact.selectNameContact(name))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Searching for contacts by phone number and return if found or not.
     */
    public boolean searchByPhoneNumber() {
        String phoneNumber = enterPhoneNumber("Enter phone number search phrase");
        if (chooseContactFromList(selectContact.selectNumberContact(phoneNumber))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Letting user choose contact from a list and saving its id.
     */
    private boolean chooseContactFromList(List<String> contacts) {
        if (contacts.size() < 1) {
            UserOutput.printLine("No contacts found");
            return false;
        }

        for (int i = 0; i < contacts.size(); i++) {
            String contact = contacts.get(i);
            UserOutput.printLine(i + 1 + ". " + contact.substring(contact.indexOf("\t") + 1));
        }
        String contact = contacts.get(UserInput.chooseFromList(contacts) - 1);
        chosenContactID = Integer.parseInt(contact.substring(0, contact.indexOf("\t")));
        return true;
    }
}
