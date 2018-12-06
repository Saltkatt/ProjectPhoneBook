package userinteraction;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * This class creates menus
 *
 * @author Daniella Norén
 * @version version 0.1 Dec 06 2018
 */

public class Menu {

    private ContactManager cm;
    private UserInput in;
    private UserOutput out;
    private static ArrayList<MenuOptions> mainMenuList;
    private static ArrayList<MenuOptions> editMenuList;

    public Menu(ContactManager cm, UserOutput out, UserInput in){
        this.cm = cm;
        this.in = in;
        this.out = out;
        fillEditMenu();
        fillMainMenu();

    }

    private void fillMainMenu(){
        mainMenuList = new ArrayList<>();
       // mainMenuList.add(new MenuOptions("1. Add conctact", cm.addContact()))
       // mainMenuList.add(new MenuOptions("2. Edit contact",

    }

    private void fillEditMenu(){
        editMenuList = new ArrayList<>();


    }


}
