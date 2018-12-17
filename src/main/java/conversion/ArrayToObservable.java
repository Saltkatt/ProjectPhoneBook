package conversion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
 class ArrayToObservable {

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
            Contact c;
            String[] contacts = list.get(i).split("\t");
            if(contacts.length == 3) {
                c = new Contact(contacts[1], contacts[2]);
                contactList.add(c);
            }
        }

        return contactList;
    }
}
