package main;

import database.Database;
import userinteraction.PhoneBookMenus;

public class Main {

    public static void main(String[] args) {
        //create database in manager instead
            Database db = new Database("");
        PhoneBookMenus.newMenu().mainMenu();

    }
}
