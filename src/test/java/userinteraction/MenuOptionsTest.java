package userinteraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuOptionsTest {

    @Test
    void badStringTest(){
        assertThrows(IllegalArgumentException.class, () -> new MenuOptions("", () -> {}));

    }

    @org.junit.jupiter.api.Test
    void getDoIt() {
    }

    @org.junit.jupiter.api.Test
    void getMenuText() {
    }
}