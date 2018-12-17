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
            Contact c = new Contact(contacts[1], contacts[2]);
            System.out.println(c.getName()+" "+c.getNumber());
        }

        return contactList;
    }
}
