package userinteraction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MenuReaderTest {

    private String test;
    ArrayList<MenuOptions> mo = new ArrayList<>();

    @BeforeAll
    void setUp(){
        mo.add(new MenuOptions("1. Say hello", () -> System.out.println("Hello")));
        mo.add(new MenuOptions("2. Change Stringtest to \"Hello\"", () -> test = "Hello"));
    }

    @Test
    void printMenu() {

        assertEquals("1. Say hello\n2. Change Stringtest to \"Hello\"", MenuReader.printMenu(mo));
    }

    @Test
    void executeMenu() {
    }

    @Test
    void readAndExecuteMenu() {
    }
}