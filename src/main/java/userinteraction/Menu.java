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
    private ArrayList<MenuOptions> mainMenuList;
    private ArrayList<MenuOptions> editMenuList;

    public Menu(ContactManager cm, UserOutput out, UserInput in){
        this.cm = cm;
        this.in = in;
        this.out = out;
    }

    private final ArrayList<MenuOptions> fillMainMenu(){
        mainMenuList = new ArrayList<>();

        return mainMenuList;
    }

    private final ArrayList<MenuOptions> fillEditMenu(){
        editMenuList = new ArrayList<>();

        return editMenuList;
    }
}
