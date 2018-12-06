package main.java.userinteraction;

public class ContactManager {

    /*
    This class manages the user interactions which concern creating new and editing existing contacts.
     */

    /*
    Getting info from user for creating a contact and providing the result to database communication method.
     */
    public void createContect() {
        addContact.addContact(enterName(), enterPhoneNumber());
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
