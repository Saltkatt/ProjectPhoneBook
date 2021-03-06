package userinteraction;

import database.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    /**
     * This class manages the user interactions which concern creating new and editing existing contacts.
     */

    private Database db;

    private int chosenContactID;

    public ContactManager(String dbName) {
        this.db = new Database(dbName);
    }

    /**
     * Getting info from user for creating a contact and providing the result to database adding method.
     */
    public void create() {
        String name = enterName("Enter name");
        String phoneNumber = enterPhoneNumber("Enter phone number");
        if(areYouSure()) {
            db.getAddContact().addContact(name, phoneNumber);
            UserOutput.printLine("Contact added");
        }else
            UserOutput.printLine("Contact not added");

    }

    /**
     * Providing database removal method with a contact id, belonging to the contact to remove.
     */
    public void remove() {
        if(areYouSure()){
            db.getRemoveContact().removeContact(chosenContactID);
            UserOutput.printLine("User deleted");
        }
        else
            UserOutput.printLine("User not deleted");

    }

    /**
     * Providing database update name method with a contact id, belonging to the contact to update, and the new name.
     */
    public void updateName() {
        String name = enterName("Enter new name");
        db.getUpdateContact().updateName(chosenContactID, name);
    }

    /**
     * Providing database update phone number method with a contact id, belonging to the contact to update,
     * and the new phone number.
     */
    public void updatePhoneNumber() {
        String phoneNumber = enterPhoneNumber("Enter new phone number");
        db.getUpdateContact().updatePhoneNumber(chosenContactID, phoneNumber);
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

    private boolean areYouSure(){
        UserOutput.printLine("Are you sure?");
        ArrayList<String> l = new ArrayList<>();
        l.add("1. Yes");
        l.add("2. No");
        l.forEach(e -> UserOutput.printLine(e));
        return UserInput.chooseFromList(l) == 1;
    }

    /**
     * Picking from full contact list and return if found or not
     */
    public boolean findByList() {
        if (chooseContactFromList(db.getSelectContact().selectAllContact())) {
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
        if (chooseContactFromList(db.getSelectContact().selectNameContact(name))) {
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
        if (chooseContactFromList(db.getSelectContact().selectNumberContact(phoneNumber))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Letting user choose contact from a list and saving its id.
     */
    private boolean chooseContactFromList(List<String> contacts) {
        if(contacts.size() != 0)
            contacts.add("Cancel");
        for (int i = 0; i < contacts.size(); i++) {
            String contact = contacts.get(i);
            UserOutput.printLine(i + 1 + ". " + contact.substring(contact.indexOf("\t") + 1));
        }

        int listChoice = UserInput.chooseFromList(contacts);
        if(listChoice == contacts.size())
            return false;

        if (listChoice == -1) {
            UserOutput.printLine("No contacts found");
            return false;
        }

        String contact = contacts.get(listChoice - 1);
        chosenContactID = Integer.parseInt(contact.substring(0, contact.indexOf("\t")));
        return true;
    }
}
