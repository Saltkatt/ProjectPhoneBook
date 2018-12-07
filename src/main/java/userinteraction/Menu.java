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
    private static ArrayList<MenuOptions> mainMenuList;
    private static ArrayList<MenuOptions> editMenuList;
    private static Menu menuCaller;

    private Menu(ContactManager cm){
        this.cm = cm;
        fillEditMenu();
        fillMainMenu();

    }

    public static Menu newMenu(){
        if(menuCaller == null)
            menuCaller = new Menu(new ContactManager());
        return menuCaller;
    }




    private void fillMainMenu(){
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new MenuOptions("1. Add contact", () -> cm.create()));
       // mainMenuList.add(new MenuOptions("2. Edit contact", () -> editMenu());

    }

    private void fillEditMenu(){
        editMenuList = new ArrayList<>();
        //editMenuList.add(new MenuOptions("1. Search for contact, () -> cm.select(UserInput.getString())); This could also go to another menu. There should be a method for retrieving name/phonenumber?
        //editMenuList.add(new MenuOptions("2. Delete contact, () -> cm
        //editMenuList.add(new MenuOptions("3. Go back", () -> mainMenu());

    }

    private void readMenu(ArrayList<MenuOptions> list){
         list.forEach(e -> UserOutput.printLine(e.getMenuText()));
         int option =  UserInput.chooseFromList(list);
         list.get(option-1).getDoIt().doThing();
    }

    public void mainMenu(){
       readMenu(mainMenuList);
    }

    public void editMenu(){
        readMenu(editMenuList);
    }



}
