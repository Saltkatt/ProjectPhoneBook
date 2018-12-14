package userinteraction;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void checkValidNameInput() {
        checkIfUserInputIsValidOrNot("name", true, "Name");
        checkIfUserInputIsValidOrNot("name", true, "Name-Name");
        checkIfUserInputIsValidOrNot("name", true, "Name'Name");
        checkIfUserInputIsValidOrNot("name", true, "Name Name");
    }

    @Test
    void checkFaultyNameInput() {
        checkIfUserInputIsValidOrNot("name", false, "Name@Name");
        checkIfUserInputIsValidOrNot("name", false, "Name123");
        checkIfUserInputIsValidOrNot("name", false, "999");
        checkIfUserInputIsValidOrNot("name", false, "Name???");
        checkIfUserInputIsValidOrNot("name", false, "\n");
        checkIfUserInputIsValidOrNot("name", false, " ");
        checkIfUserInputIsValidOrNot("name", false, "Abcdefghiasdaopfspiansfpianspfinaspfnaspfniapsnpasnfpasnfsapfnpaonf");
    }

    @Test
    void checkValidPhoneNumberInput() {
        checkIfUserInputIsValidOrNot("phoneNumber", true, "1");
        checkIfUserInputIsValidOrNot("phoneNumber", true, "99999999999999999");
        checkIfUserInputIsValidOrNot("phoneNumber", true, "0123456789");
    }

    @Test
    void checkFaultyPhoneNumberInput() {
        checkIfUserInputIsValidOrNot("phoneNumber", false, "aaa");
        checkIfUserInputIsValidOrNot("phoneNumber", false, "/");
        checkIfUserInputIsValidOrNot("phoneNumber", false, "\n");
        checkIfUserInputIsValidOrNot("phoneNumber", false, " ");
        checkIfUserInputIsValidOrNot("phoneNumber", false, "999999999999999999999999999999999999999999");
    }

    private void checkIfUserInputIsValidOrNot(String nameOrPhoneNumber, boolean shouldBeValid, String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            String returnedInput;

            if (nameOrPhoneNumber.equals("name")) {
                returnedInput = UserInput.name();
            } else {
                returnedInput = UserInput.phoneNumber();
            }

            if (shouldBeValid && returnedInput.equals(userInput)) {
                assertTrue(true);
            } else if (shouldBeValid && !returnedInput.equals(userInput)) {
                fail("User input should be valid and is returned as a valid input, but is not returned correctly");
            } else {
                fail("User input should not be valid but is returned as a valid input");
            }
        } catch (Exception e) {
            String actual = out.toString().trim().replace("\r", "");
            String expected = "Invalid input, try again!";
            assertEquals(expected, actual);
        }
    }

    @Test
    void checkValidListChoiceInput() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, true, "1");
        checkIfUserInputIsValidOrNot(testList, true, "5");
    }

    @Test
    void checkFaultyListChoiceInput() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, false, " ");
        checkIfUserInputIsValidOrNot(testList, false, "\n");
        checkIfUserInputIsValidOrNot(testList, false, "6");
        checkIfUserInputIsValidOrNot(testList, false, "0");
        checkIfUserInputIsValidOrNot(testList, false, "abc");
    }

    private <T> void checkIfUserInputIsValidOrNot(List<T> list, boolean shouldBeValid, String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            int returnedInput = UserInput.chooseFromList(list);

            if (shouldBeValid && returnedInput == Integer.parseInt(userInput)) {
                assertTrue(true);
            } else if (shouldBeValid && returnedInput != Integer.parseInt(userInput)) {
                fail("User input should be valid and is returned as a valid input, but is not returned correctly");
            } else {
                fail("User input should not be valid but is returned as a valid input");
            }
        } catch (Exception e) {
            String actual = out.toString().trim().replace("\r", "");
            String expected = "Invalid input, try again!";
            assertEquals(expected, actual);
        }
    }
}