package main;

import conversion.Contact;
import database.Database;
import javafx.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample.fxml"));
        Parent root = loader.load();

public class Main {

    public static void main(String[] args) {
        launch(args);
        for(Contact c: Controller.searchBackup){
            Controller.db.getAddContact().addContact(c.getName(), c.getNumber());
        }
        //PhoneBookMenus.newMenu().mainMenu();
    }

}
