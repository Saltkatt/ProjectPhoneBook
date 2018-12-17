package javafx;
import conversion.ArrayToObservable;
import conversion.Contact;
import database.Database;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


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

    @FXML Label nameLabel;
    @FXML Label numberLabel;

    private Database db = new Database("datebasefx.db");
    private Contact currentContact;
    private Boolean confirmUpdate;



    public void confirm(){
        if(nameField.getText().matches("^[a-zA-Z]{1,30}$") && numberField.getText().matches("^[0-9]{1,20}$"))
            if(currentContact != null && confirmUpdate)
                db.getRemoveContact().removeContact(Integer.parseInt(currentContact.getId()));
        db.getAddContact().addContact(nameField.getText(), numberField.getText());

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
        ObservableList<Contact> observableContacts = ArrayToObservable.toContactObservable(db.getSelectContact().selectAllContact());
        tableView.setItems(observableContacts);
    }

    public void updateContact(){
        confirmUpdate = true;
        viewTextFields(true);
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
