package userinteraction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MenuReaderTest {

    private String test = "";
    ArrayList<MenuOptions> mo = new ArrayList<>();

    @BeforeAll
    void setUp(){
        mo.add(new MenuOptions("1. Say hello", () -> System.out.print("Hello")));
        mo.add(new MenuOptions("2. Change Stringtest to \"Hello\"", () -> test = "Hello"));
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
    void executeMenuTest() {
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

}