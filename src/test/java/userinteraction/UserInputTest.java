package userinteraction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

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
    }

    @Test
    void chooseFromList() {
    }
}