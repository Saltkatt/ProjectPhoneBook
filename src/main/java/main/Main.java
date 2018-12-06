package main;

import database.*;

public class Main {

    public static void main(String[] args) {
        new CreateDatabase().createDatabaseIfNotExist();
    }
}
