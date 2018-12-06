package main.java.userinteraction;

public class ContactManager {

    /*
    This class manages the user interactions which concern creating new and editing existing contacts.
     */

    /*
    Getting info from user for creating a contact and providing the result to database adding method.
     */
    public void create() {
        addContact.addContact(enterName(), enterPhoneNumber());
    }

    /*
    Providing database removal method with a contact id belonging to the contact to remove.
     */
    public void remove(int contactID) {
        removeContact.removeContact(contactID);
    }

    /*
    Collect name input from user and return it
     */
    public String enterName() {
        userinteraction.UserOutput.printLine("Enter name:");
        return userinteraction.UserInput.name();
    }

    /*
    Collect phone number input from user and return it
    */
    public String enterPhoneNumber() {
        userinteraction.UserOutput.printLine("Enter phone number:");
        return userinteraction.UserInput.phoneNumber();
    }

}
