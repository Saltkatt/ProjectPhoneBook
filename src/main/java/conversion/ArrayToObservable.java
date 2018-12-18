package conversion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import userinteraction.UserOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that converts a List from SelectContact-methods
 * and creates Contact-instances and an ObservableList for JavaFX
 * with all the Contacts
 *
 * It is tailormade for SelectContact-class, it doesn't work if the
 * List<String> doesn't follow the pattern of the returning List<String> from
 * SelectContact-methods
 *
 * @author Daniella Norén
 * @version 1 Build 2018
 */
public class ArrayToObservable {

    /**
     * Static method that takes a List<String> from
     * SelectContact, creates a Contact-instance for each
     * entry in the List and adds that Contact to an ObservableList<Contact>
     * used for JavaFX
     *
     * @param list List<String> from one of the SelectContact-methods for getting data from Contact-database
     * @return ObservableList containing Contacts from the contact-database
     */
    public static ObservableList<Contact> toContactObservable(List<String> list){
        ObservableList<Contact> contactList = FXCollections.observableArrayList();
        for(int i = 0; i < list.size(); i++){

            String contact = list.get(i);
            String[] contacts = contact.split("\t");
            contactList.add(new Contact(contacts[0], contacts[1], contacts[2]));
        }

        return contactList;
    }
}
