package main;

import conversion.Contact;
import database.Database;
import javafx.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userinteraction.MenuOption;
import userinteraction.MenuReader;
import userinteraction.PhoneBookMenus;
import userinteraction.UserInput;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class that starts the application.
 */
public class Main extends Application {

    /**
     * Sets up some settings if the program is chosen to run as an javaFX application so it's able to.
     */
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

    /**
     * Prints out an option in the console when launching the program whether the user wants to run the program in
     * the console or javaFX and starts the application based on the selected option.
     */
    public static void main(String[] args) {
        List<MenuOption> menu = new ArrayList<>();
        menu.add(new MenuOption("1. Console version", () -> PhoneBookMenus.newMenu().mainMenu()));
        menu.add(new MenuOption("2. Interface version", () -> launch(args)));
        MenuReader.printMenu(menu);
        MenuReader.executeMenu(menu, UserInput.chooseFromList(menu)-1);
        for(Contact c: Controller.storedContacts){
            new Database("my_contacts.db").getAddContact().addContact(c.getName(), c.getNumber());
        }
    }

}
