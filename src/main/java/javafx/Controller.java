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

/**
 * This class manages the communication between the FX version of this program and the database.
 * @author Ida
 */
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


    private Database db = new Database("my_contacts.db");
    private Contact currentContact;
    private String whatToConfirm = "";

    private ObservableList<Contact> observableContacts;
    public static List<Contact> storedContacts = new ArrayList<>();

    /**
     * This method/button gives the user fields where they can enter information about their contact and let.
     *
     * "viewTextFields(true)" displays the fields where the user can enter information.
     * "nameField.setText("")" makes sure the fields are empty since the user wants to add a new contact.
     * "whatToConfirm="add"" updates the string the confirm button use to know what kind of information to
     * confirm (add or update).
     */
    public void addContact(){
        whatToConfirm = "add";
        nameField.setText("");
        numberField.setText("");
        viewTextFields(true);
    }

    /**
     * This method/button gives the user fields where they can update information of the selected contact.
     * The fields works in the same way as for addContact().
     */
    public void updateContact(){
        if(currentContact != null){
            whatToConfirm = "update";
            viewTextFields(true);
            nameField.setText(currentContact.getName());
            numberField.setText(currentContact.getNumber());
        }
    }

    /**
     * Deletes the selected contact.
     */
    public void deleteContact(){
        if(currentContact != null){
            db.getRemoveContact().removeContact(Integer.parseInt(currentContact.getId()));
            updateList();
        }
    }

    /**
     * This method takes the text from the input fields and adds a new contact to the database with those fields.
     * If it's an update it first removes the selected contact. Although updating something directly without removing
     * is possible to do with a database, the tableView needs to add or remove something to display updated information.
     */
    public void confirm(){
        if(nameField.getText().matches("^[a-zåäöA-ZÅÄÖ]{1,30}$") && numberField.getText().matches("^[0-9]{1,20}$"))
            if(currentContact != null && whatToConfirm.equals("update"))
                db.getRemoveContact().removeContact(Integer.parseInt(currentContact.getId()));
        db.getAddContact().addContact(nameField.getText(), numberField.getText());

        searchField.setText("");
        search();
        updateList();
        viewTextFields(false);
    }

    /**
     * Whenever the tableView is clicked it stores the selected contact in the "currentContact" variable.
     */
    public void tableViewClicked(){
        if(tableView.getSelectionModel().getSelectedItem() != null){
            currentContact = tableView.getSelectionModel().getSelectedItem();
            if(whatToConfirm.equals("update")){
                nameField.setText(currentContact.getName());
                numberField.setText(currentContact.getNumber());
            }
        }
    }

    /**
     * This method enables or disables whether the text input fields are visible or not.
     * @param b true or false depending on whether the fields should be set visible or not.
     */
    private void viewTextFields(boolean b){
        nameField.setVisible(b);
        numberField.setVisible(b);
        nameLabel.setVisible(b);
        numberLabel.setVisible(b);
        confirmButton.setVisible(b);
    }

    /**
     * Selects everything from the database, converts it into an observable list and then adds all of its values
     * to the tableView.
     */
    private void updateList(){
        observableContacts = ArrayToObservable.toContactObservable(db.getSelectContact().selectAllContact());
        tableView.setItems(observableContacts);
    }

    /**
     * Note before method explanation: the tableView don't seem to detect if the columns update but do detect when a
     * column is added or removed, therefore the choice of temporarily removing and storing away contacts while searching
     * is used here.
     *
     * Every time the search field changes this method starts with adding all stored contacts to the database
     * and updates the tableView. Stored contacts only contain temporarily removed contacts. For example if the
     * user enter a letter in the search field, some contacts temporarily gets removed from the list and stored
     * in the storedContacts list (the normal list only displays contacts matching the search field now). When a
     * second letter is typed the database adds all the temporary contacts back to the normal list so the new search
     * condition can be compared with all existing contacts. This process repeats.
     */
    public void search(){

        for(Contact c: storedContacts){
            db.getAddContact().addContact(c.getName(), c.getNumber());
        }
        storedContacts.clear();
        updateList();


        List<Contact> nameMatch = ArrayToObservable.toContactObservable(db.getSelectContact().
                selectNameContact(searchField.getText()));
        List<Contact> numberMatch = ArrayToObservable.toContactObservable(db.getSelectContact().
                selectNumberContact(searchField.getText()));

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
                storedContacts.add(new Contact(c.getId(), c.getName(), c.getNumber()));
                db.getRemoveContact().removeContact(Integer.parseInt(c.getId()));
            }

        }
        updateList();
    }

    /**
     * Initialises values before application starts
     */
    public void init(){
        viewTextFields(false);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        updateList();
    }

    public void setStage(){
    }



}
