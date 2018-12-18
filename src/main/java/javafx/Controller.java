package javafx;
import conversion.ArrayToObservable;
import conversion.Contact;
import database.Database;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    @FXML TableView<Contact> tableView;
    @FXML TableColumn<Contact, String> nameColumn;
    @FXML TableColumn<Contact, String> numberColumn;

    @FXML Button addContactButton;
    @FXML Button updateContactButton;
    @FXML Button deleteContactButton;
    @FXML Button confirmButton;

    @FXML TextField nameField;
    @FXML TextField numberField;
    @FXML TextField searchField;

    @FXML Label nameLabel;
    @FXML Label numberLabel;




    public static Database db = new Database("my_contacts.db");
    private Contact currentContact;
    private Boolean confirmUpdate = false;

    private ObservableList<Contact> observableContacts;
    public static List<Contact> searchBackup = new ArrayList<>();

    public void search(){

        for(Contact c: searchBackup){
            db.getAddContact().addContact(c.getName(), c.getNumber());
        }
        searchBackup.clear();
        updateList();


        List<Contact> nameMatch = ArrayToObservable.toContactObservable(db.getSelectContact().selectNameContact(searchField.getText()));
        List<Contact> numberMatch = ArrayToObservable.toContactObservable(db.getSelectContact().selectNumberContact(searchField.getText()));

        for(Contact c: observableContacts){
            boolean b = false;
            for(Contact d: nameMatch) {
                if (c.getId().equals(d.getId()))
                    b = true;
            }
            for(Contact d: numberMatch) {
                if (c.getId().equals(d.getId()))
                    b = true;
            }
            if(!b){
                searchBackup.add(new Contact(c.getId(), c.getName(), c.getNumber()));
                db.getRemoveContact().removeContact(Integer.parseInt(c.getId()));
            }

        }
        updateList();
    }


    public void confirm(){


        if(nameField.getText().matches("^[a-zA-Z]{1,30}$") && numberField.getText().matches("^[0-9]{1,20}$"))
            if(currentContact != null && confirmUpdate)
                db.getRemoveContact().removeContact(Integer.parseInt(currentContact.getId()));
        db.getAddContact().addContact(nameField.getText(), numberField.getText());

        searchField.setText("");
        search();
        updateList();
        viewTextFields(false);

    }

    private void viewTextFields(boolean b){
        nameField.setVisible(b);
        numberField.setVisible(b);
        nameLabel.setVisible(b);
        numberLabel.setVisible(b);
        confirmButton.setVisible(b);
    }

    public void addContact(){
        confirmUpdate = false;
        nameField.setText("");
        numberField.setText("");
        viewTextFields(true);
    }

    public void tableViewClicked(){
        if(tableView.getSelectionModel().getSelectedItem() != null){
            currentContact = tableView.getSelectionModel().getSelectedItem();
            if(confirmUpdate){
                nameField.setText(currentContact.getName());
                numberField.setText(currentContact.getNumber());
            }
        }
    }

    private void updateList(){
        observableContacts = ArrayToObservable.toContactObservable(db.getSelectContact().selectAllContact());
        tableView.setItems(observableContacts);
    }

    public void updateContact(){
        if(currentContact != null){
            confirmUpdate = true;
            viewTextFields(true);
            nameField.setText(currentContact.getName());
            numberField.setText(currentContact.getNumber());
        }
    }

    public void deleteContact(){


        if(currentContact != null){
            db.getRemoveContact().removeContact(Integer.parseInt(currentContact.getId()));
            updateList();
        }
    }


    public void setStage(){

    }


    public void init(){
        viewTextFields(false);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));



        updateList();
    }
}
