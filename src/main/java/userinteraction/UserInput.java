package main.java.userinteraction;

import java.util.Scanner;

public class UserInput {

    /**
     This class handles all user output.
     */

    private static Scanner sc = new Scanner(System.in);

    /**
     Controls the user input and returns it when it's a valid name input.
     */
    public static String name() {
        String name;
        boolean validInput;
        do {
            name = sc.nextLine().trim();
            if (name.matches("[a-öA-Ö\\-\\s\']{1,30}")) {
                validInput = true;
            } else {
                UserOutput.printLine("Invalid input, try again!");
                validInput = false;
            }
        } while (!validInput);
        return name;
    }

}
