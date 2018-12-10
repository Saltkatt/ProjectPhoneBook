package userinteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuOptionsTest {

    @Test
    void badStringTest(){
        assertThrows(IllegalArgumentException.class, () -> new MenuOptions("", () -> {}));

    }

    @Test
    void getDoIt() {
        DoSomething d = () -> System.out.println("Test successful");
        DoSomething e = () -> System.out.println("Test");
        MenuOptions mo = new MenuOptions("1", d);
        assertEquals(d, mo.getDoIt());
        assertFalse(mo.getDoIt().equals(e));
        assertTrue(!(mo.getDoIt().equals(e)));
        assertTrue(mo.getDoIt().equals(d));
        MenuOptions mo2 = new MenuOptions("2", e);
        assertFalse(mo2.getDoIt().equals(d));
        assertTrue(mo2.getDoIt().equals(e));
        assertFalse(mo2.getDoIt().equals(mo.getDoIt()));
    }

    @org.junit.jupiter.api.Test
    void getMenuText() {
    }
}