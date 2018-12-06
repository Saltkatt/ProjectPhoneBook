package userinteraction;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This class creates menus
 *
 * @author Daniella Norén
 * @version version 0.1 Dec 06 2018
 */

public class MenuLists {

    private ContactManager cm;
    private UserInput in;
    private UserOutput out;
    private static ArrayList<MenuOptions> mainMenuList;
    private static ArrayList<MenuOptions> editMenuList;

    public MenuLists(ContactManager cm, UserOutput out, UserInput in){
        this.cm = cm;
        this.in = in;
        this.out = out;
        mainMenuList = new ArrayList<>();
    }

    private final void fillMainMenu(){

       // mainMenuList.add(new MenuOptions("1. Add conctact", cm.addContact()))
       // mainMenuList.add(new MenuOptions("2. Edit contact",
    }

    private final void fillEditMenu(){
        editMenuList = new ArrayList<>();


    }

    public ArrayList<MenuOptions> getMainMenuList(){
        return mainMenuList;
    }
    public ArrayList<MenuOptions> getEditMenuList(){
        return editMenuList;
    }
}
