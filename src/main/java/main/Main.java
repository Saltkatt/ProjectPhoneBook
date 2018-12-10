package main;

import database.*;
import userinteraction.Menu;

public class Main {

    public static void main(String[] args) {
        new CreateDatabase().createDatabaseIfNotExist();

        Menu.newMenu().mainMenu();
    }
}
