package javafx;

import conversion.ArrayToObservable;
import conversion.Contact;
import database.Database;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Controller {

    private Database db = new Database("datebasefx.db");

    @FXML TableView<Contact> tableView;
    @FXML TableColumn<Contact, String> nameColumn;
    @FXML TableColumn<Contact, String> numberColumn;
    @FXML Button addContactButton, addContactButton2;

    ObservableList<Contact> observableContacts = FXCollections.observableArrayList();


    public void addContact(){
        observableContacts.add(new Contact("hiii", "123"));
        tableView.setItems(observableContacts);

    }

    public void addContact2(){

    }


    public void setStage(){

    }
    void doSomething(){
        System.out.println("yay");
        //tableView.setItems();

    }


    public void init(){
//        ArrayToObservable.toContactObservable(db.getSelectContact().selectAllContact()).
//                addListener((ListChangeListener<Contact>) c -> doSomething());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

    }
}
