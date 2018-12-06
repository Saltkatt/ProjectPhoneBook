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
       // mainMenuList.add(new MenuOptions("2. Edit contact", () -> editMenu());

    }

    private void fillEditMenu(){
        editMenuList = new ArrayList<>();
        //editMenuList.add(new MenuOptions("1. Search for contact, () -> cm.select(UserInput.getString())); This could also go to another menu. There should be a method for retrieving name/phonenumber?
        //editMenuList.add(new MenuOptions("2. Delete contact, () -> cm
        //editMenuList.add(new MenuOptions("3. Go back", () -> mainMenu());

    }

    private void readMenu(ArrayList<MenuOptions> list){
        //TODO: Call useroutput to print each String
        //int option = in.getOption(list); TODO: Get int-answer from userInput
        //list.get(Integer.parseInt(option)-1).getDoIt().doThing(); Run method
    }

    public void mainMenu(){
       readMenu(mainMenuList);
    }

    public void editMenu(){
        readMenu(editMenuList);
    }



}
