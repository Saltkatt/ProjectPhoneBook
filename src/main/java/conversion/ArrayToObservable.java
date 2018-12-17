package conversion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import userinteraction.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class ArrayToObservable {

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
