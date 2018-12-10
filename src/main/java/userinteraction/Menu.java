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
    private static ArrayList<MenuOptions> searchMenuList;
    private static Menu menuInstance;

    /**
     * Private constructor for Menu
     * @param cm The ContactManager that manages the Database of Contacts
     */
    private Menu(ContactManager cm){
        this.cm = cm;
        fillEditMenu();
        fillMainMenu();
        fillSearchMenu();

    }

    /**
     * Method that returns the only instance of this class
     *
     * @return The one instance of class Menu
     */
    public static Menu newMenu(){
        if(menuInstance == null)
            menuInstance = new Menu(new ContactManager());
        return menuInstance;
    }


    /**
     * Method that initializes and adds all MenuOptions-object
     * into arrayList mainMenuList
     *
     * This method is called from Menu-constructor
     */

    private void fillMainMenu(){
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new MenuOptions("1. Add contact", () -> { cm.create(); mainMenu();} ));
        mainMenuList.add(new MenuOptions("2. View/Edit contact", () -> { cm.findByList();
                                                                                  editMenu();}));
        mainMenuList.add(new MenuOptions("3. Search contact", () -> searchMenu()));
        mainMenuList.add(new MenuOptions("4. Exit", () -> {}));

    }
    /**
     * Method that initializes and adds all MenuOptions-object
     * into arrayList editMenuList
     *
     * This method is called from Menu-constructor
     */

    private void fillEditMenu(){
        editMenuList = new ArrayList<>();
        editMenuList.add(new MenuOptions("1. Update name", () -> {cm.updateName(); editMenu();}));
        editMenuList.add(new MenuOptions("2. Update phonenumber", () -> { cm.updatePhoneNumber(); editMenu();}));
        editMenuList.add(new MenuOptions("3. Delete contact", () -> { cm.remove(); editMenu();} ));
        editMenuList.add(new MenuOptions("4. Back to main menu", () -> mainMenu()));

    }

    private void fillSearchMenu(){
        searchMenuList = new ArrayList<>();
        searchMenuList.add(new MenuOptions("1. Search by name", () -> {if(cm.searchByName()) editMenu(); searchMenu();}));
        searchMenuList.add(new MenuOptions("2. Search by Phonenumber", () -> { if(cm.searchByPhoneNumber()) editMenu(); searchMenu();}));
        searchMenuList.add(new MenuOptions("3. Go back", () -> mainMenu()));

    }

    /**
     * Method that helps print menu, get user input for said menu
     * and runs method corresponding to input
     *
     * @param list of menuoptions that should be run
     */
    private void readMenu(ArrayList<MenuOptions> list){
         list.forEach(e -> UserOutput.printLine(e.getMenuText()));
         int option =  UserInput.chooseFromList(list);
         list.get(option-1).getDoIt().doThing();
    }

    /**
     * Calls readMenu(ArrayList<> list) with mainMenuList as argument
     */
    public void mainMenu(){
       readMenu(mainMenuList);
    }
    /**
     * Calls readMenu(ArrayList<> list) with editMenuList as argument
     */
    public void editMenu(){
        readMenu(editMenuList);
    }

    public void searchMenu(){
        readMenu(searchMenuList);
    }



}
