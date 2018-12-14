package userinteraction;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @Test
    void name() {
        ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
        System.setIn(in);
        String test = UserInput.name();
        assertEquals(test, "test");

    }

    @Test
    void phoneNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);
        String test = UserInput.phoneNumber();
        assertEquals(test, "5");
    }

    @Test
    void chooseFromList() {
    }
}