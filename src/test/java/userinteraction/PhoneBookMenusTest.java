package userinteraction;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookMenusTest {

    private static DoSomething d = () -> {};

    @Test
    void listIsCopyTest(){
        ArrayList<MenuOption> main = PhoneBookMenus.newMenu().getMainMenuList();
        ArrayList<MenuOption> edit = PhoneBookMenus.newMenu().getEditMenuList();
        ArrayList<MenuOption> search = PhoneBookMenus.newMenu().getSearchMenuList();

        search.remove(2);
        assertTrue(search.size() == 2 && PhoneBookMenus.newMenu().getSearchMenuList().size() == 3);
        search.add(new MenuOption("This does not belong", d));
        assertTrue(search.get(2).getMenuText().equals("This does not belong") &&
                   !(PhoneBookMenus.newMenu().getSearchMenuList().get(2).equals("This does not belong")));

        edit.add(new MenuOption("Wrong", d));
        assertTrue(edit.size() == 5 && PhoneBookMenus.newMenu().getEditMenuList().size() == 4);

        main.add(new MenuOption("Wrong", d));
        assertTrue(main.size() == 5 && PhoneBookMenus.newMenu().getMainMenuList().size() == 4);
    }

   @Test
    void getMainMenuListStringTest(){
        ArrayList<MenuOption> edit = PhoneBookMenus.newMenu().getEditMenuList();
        assertEquals("1. Update name", edit.get(0).getMenuText());
        assertEquals("2. Update phonenumber", edit.get(1).getMenuText());
        assertEquals("3. Delete contact", edit.get(2).getMenuText());
        assertEquals("4. Back to main menu", edit.get(3).getMenuText());
    }

    @Test
    void getEditMenuListStringTest(){
        ArrayList<MenuOption> main = PhoneBookMenus.newMenu().getMainMenuList();
        assertEquals("1. Add contact", main.get(0).getMenuText());
        assertEquals("2. View/Edit contact", main.get(1).getMenuText());
        assertEquals("3. Search contact", main.get(2).getMenuText());
        assertEquals("4. Exit", main.get(3).getMenuText());

    }
    @Test
    void getSearchMenuListStringTest(){
        ArrayList<MenuOption> search = PhoneBookMenus.newMenu().getSearchMenuList();
        assertEquals("1. Search by name", search.get(0).getMenuText());
        assertEquals("2. Search by Phonenumber", search.get(1).getMenuText());
        assertEquals("3. Go back", search.get(2).getMenuText());

    }
}