package userinteraction;

import java.util.List;
import java.util.Scanner;

public class UserInput {

    /**
     * This class handles all user output.
     */

    /**
     * Ask for user input and returns it when it's a valid name input.
     */
    public static String name() {
        Scanner sc = new Scanner(System.in);
        String userInput;
        while (!checkUserInputValidity(userInput = sc.nextLine().trim(), "^[a-zåäöA-ZÅÄÖ]{1,30}$"));
        return userInput;
    }

    /**
     * Ask for user input and returns it when it's a valid phone number input.
     */
    public static String phoneNumber() {
        Scanner sc = new Scanner(System.in);
        String userInput;
        while (!checkUserInputValidity(userInput = sc.nextLine().trim(), "[0-9]{1,20}"));
        return userInput;
    }

    /**
     * Ask for user input and returns it when it's a valid list choice input .
     */
    public static <T> int chooseFromList(List<T> list) {
        Scanner sc = new Scanner(System.in);
        if (list.size() < 1) {
            return -1;
        }

        int max = list.size();
        String userInput;
        while (!checkUserInputValidity(userInput = sc.nextLine().trim(), "[0-9]+", 1, max));
        return Integer.parseInt(userInput);
    }

    /**
     * Checks the user input and returns whether it matches a certain pattern or not.
     */
    private static boolean checkUserInputValidity(String userInput, String regex) {
        if (userInput.matches(regex)) {
            return true;
        } else {
            UserOutput.printLine("Invalid input, try again!");
            return false;
        }
    }

    /**
     * Checks the user input and returns whether it matches a certain pattern,
     * and if numbers entered is between certain values, or not.
     */
    private static boolean checkUserInputValidity(String userInput, String regex, int min, int max) {
        if (userInput.matches(regex) && Integer.parseInt(userInput) >= min && Integer.parseInt(userInput) <= max) {
            return true;
        } else {
            UserOutput.printLine("Invalid input, try again!");
            return false;
        }
    }
}
