package userinteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test that the Class MenuOption works correctly
 *
 * @author Daniella Norén
 * @version 1 Build 2018
 */
class MenuOptionTest {
    /**
     * If given an empty String as MenuText it should throw an IllegalArgumentException
     */
    @Test
    void badStringTest(){
        assertThrows(IllegalArgumentException.class, () -> new MenuOption("", () -> {}));
        String str = "";
        assertThrows(IllegalArgumentException.class, () -> new MenuOption(str,
                () -> {}));

    }

    /**
     * Check so that the DoSomething-method returns correctly and when executed
     * does what it should do
     */
    @Test
    void getDoIt() {
        DoSomething d = () -> System.out.println("Test successful");
        DoSomething e = () -> System.out.println("Test");
        MenuOption mo = new MenuOption("1", d);
        assertEquals(d, mo.getDoIt());
        assertFalse(mo.getDoIt().equals(e));
        assertTrue(!(mo.getDoIt().equals(e)));
        assertTrue(mo.getDoIt().equals(d));
        MenuOption mo2 = new MenuOption("2", e);
        assertFalse(mo2.getDoIt().equals(d));
        assertTrue(mo2.getDoIt().equals(e));
        assertFalse(mo2.getDoIt().equals(mo.getDoIt()));
    }

    /**
     * Check so that the getMenuText() returns the correct
     * MenuText given into the constructor
     */
    @Test
    void getMenuText() {
        String str = "Test";
        MenuOption mo = new MenuOption(str, () -> {});
        assertEquals(str, mo.getMenuText());
        str = "This is another test!!!!!";
        mo = new MenuOption(str, () -> {});
        assertEquals(str, mo.getMenuText());
        assertFalse("Test".equals(mo.getMenuText()));
    }
}