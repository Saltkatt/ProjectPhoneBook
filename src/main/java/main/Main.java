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

        Controller controller = loader.getController();
        controller.init();
        controller.setStage();

        primaryStage.setTitle("PhoneBook");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        for(Contact c: Controller.searchBackup){
            Controller.db.getAddContact().addContact(c.getName(), c.getNumber());
        }
        //PhoneBookMenus.newMenu().mainMenu();
    }

}
