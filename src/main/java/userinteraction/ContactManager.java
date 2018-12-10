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
     * Picking from full contact list and returning the chosen contacts id.
     */
    public void findByList() {
        chosenContactID = chooseContactFromList(selectContact.selectAllContact());
    }

    /**
     * Searching for contacts by name and returning the chosen contacts id.
     */
    public void searchByName() {
        String name = enterName("Enter name search phrase");
        chosenContactID = chooseContactFromList(selectContact.selectNameContact(name));
    }

    /**
     * Searching for contacts by phone number and returning the chosen contacts id.
     */
    public void searchByPhoneNumber() {
        String phoneNumber = enterPhoneNumber("Enter phone number search phrase");
        chosenContactID = chooseContactFromList(selectContact.selectNumberContact(phoneNumber));
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
