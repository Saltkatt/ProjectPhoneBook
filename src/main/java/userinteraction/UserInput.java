package main.java.userinteraction;

import java.util.Scanner;

public class UserInput {

    /**
     This class handles all user output.
     */

    private static Scanner sc = new Scanner(System.in);

    /**
     Checks the user input and returns it when it's a valid name input.
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

    /**
     Checks the user input and returns it when it's a valid phone number input.
     */
    public static String phoneNumber() {
        String phoneNumber;
        boolean validInput;
        do {
            phoneNumber = sc.nextLine().trim();
            if (phoneNumber.matches("[0-9]{20}")) {
                validInput = true;
            } else {
                UserOutput.printLine("Invalid input, try again!");
                validInput = false;
            }
        }while (!validInput);
        return phoneNumber;
    }

}
