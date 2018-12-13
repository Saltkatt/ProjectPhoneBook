package userinteraction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MenuReaderTest {

    private String test = "";
    ArrayList<MenuOption> mo = new ArrayList<>();

    @BeforeAll
    void setUp(){
        mo.add(new MenuOption("1. Say hello", () -> System.out.print("Hello")));
        mo.add(new MenuOption("2. Change Stringtest to \"Hello\"", () -> test = "Hello"));
    }

    @Test
    void printMenuTest() {
        PrintStream stream = new PrintStream(System.out);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        MenuReader.printMenu(mo);
        String s = out.toString();
        out.reset();
        System.out.println("1. Say hello");
        System.out.println("2. Change Stringtest to \"Hello\"");
        String m = out.toString();
        assertEquals(s, m);
        System.setOut(stream);
    }

    @Test
    void executeMenuTest() throws SQLException {
        test = "";
        PrintStream stream = new PrintStream(System.out);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        mo.get(0).getDoIt().doThing();
        assertEquals("Hello", out.toString());
        System.setOut(stream);
        assertEquals("", test);
        mo.get(1).getDoIt().doThing();
        assertEquals("Hello", test);

    }

    @Test
    void illegalInputTest(){
        ArrayList<MenuOption> list = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> MenuReader.printMenu(list));
        list.add(new MenuOption("Test", () -> {}));
        assertThrows(IllegalArgumentException.class, () -> MenuReader.executeMenu(list, 2));
        assertThrows(IllegalArgumentException.class, () -> MenuReader.executeMenu(list, 10));
        assertThrows(IllegalArgumentException.class, () -> MenuReader.executeMenu(list, 100));
        assertThrows(IllegalArgumentException.class, () -> MenuReader.executeMenu(list, -1));

    }

}