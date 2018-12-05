package Main;

import Database.CreateDatabase;

public class Main {

    public static void main(String[] args) {
        new CreateDatabase().createDatabaseIfNotExist();
    }
}
