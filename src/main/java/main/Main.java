package main;

import database.*;
import userinteraction.Menu;

public class Main {

    public static void main(String[] args) {
        //TODO create this instance in contact manager?
        //Database db = new Database("phone_book.db");
        //db.setupDatabase();


        Menu.newMenu().mainMenu();
    }
}
