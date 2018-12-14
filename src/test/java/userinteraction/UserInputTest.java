package userinteraction;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void checkValidNameInputRegular() {
        checkIfUserInputIsValidOrNot("name", true, "Name");
    }

    @Test
    void checkValidNameInputWithHyphen() {
        checkIfUserInputIsValidOrNot("name", true, "Name-Name");
    }

    @Test
    void checkValidNameInputWithApostrophe() {
        checkIfUserInputIsValidOrNot("name", true, "Name'Name");
    }

    @Test
    void checkValidNameInputWithWhitespace() {
        checkIfUserInputIsValidOrNot("name", true, "Name Name");
    }

    @Test
    void checkFaultyNameInputWithNumbers() {
        checkIfUserInputIsValidOrNot("name", false, "Name123");
    }

    @Test
    void checkFaultyNameInputWithNoInput() {
        checkIfUserInputIsValidOrNot("name", false, " ");
    }

    @Test
    void checkFaultyNameInputWithTooManyChars() {
        checkIfUserInputIsValidOrNot("name", false, "Abcdefghiasdaopfspiansfpianspfinaspfnaspfniapsnpasnfpasnfsapfnpaonf");
    }

    @Test
    void checkFaultyNameInputFaultyChar() {
        checkIfUserInputIsValidOrNot("name", false, "Name???");
    }

    @Test
    void checkValidPhoneNumberInputWithLowNumber() {
        checkIfUserInputIsValidOrNot("phoneNumber", true, "1");
    }

    @Test
    void checkValidPhoneNumberInputWithLargeNumber() {
        checkIfUserInputIsValidOrNot("phoneNumber", true, "99999999999999999");
    }

    @Test
    void checkValidPhoneNumberInputWithAllNumbers() {
        checkIfUserInputIsValidOrNot("phoneNumber", true, "0123456789");
    }

    @Test
    void checkFaultyPhoneNumberInputWithChars() {
        checkIfUserInputIsValidOrNot("phoneNumber", false, "aaa");
    }

    @Test
    void checkFaultyPhoneNumberInputWithNoInput() {
        checkIfUserInputIsValidOrNot("phoneNumber", false, " ");
    }

    @Test
    void checkFaultyPhoneNumberInputWithTooManyNumbers() {
        checkIfUserInputIsValidOrNot("phoneNumber", false, "999999999999999999999999999999999999999999");
    }

    @Test
    void checkFaultyPhoneNumberInputWithFaultyChar() {
        checkIfUserInputIsValidOrNot("phoneNumber", false, "///");
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
    void checkValidListChoiceInputWithLowNumber() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, true, "1");
    }

    @Test
    void checkValidListChoiceInputWithHighNumber() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, true, "5");
    }

    @Test
    void checkFaultyListChoiceInputWithNoInput() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, false, " ");
    }

    @Test
    void checkFaultyListChoiceInputWithTooLargeNumber() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, false, "6");
    }

    @Test
    void checkFaultyListChoiceInputWithTooLowNumber() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, false, "0");
    }

    @Test
    void checkFaultyListChoiceInputWithFaultyChar() {
        List<String> testList = Arrays.asList("This", "Is", "A", "Test", "List");
        checkIfUserInputIsValidOrNot(testList, false, "a");
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