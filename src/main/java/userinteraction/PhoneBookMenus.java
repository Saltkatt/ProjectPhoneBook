package userinteraction;

import java.util.ArrayList;

/**
 * This class creates menus
 *
 * @author Daniella Norén
 * @version version 0.1 Dec 06 2018
 */

public class PhoneBookMenus {

    private ContactManager cm;
    private static ArrayList<MenuOption> mainMenuList;
    private static ArrayList<MenuOption> editMenuList;
    private static ArrayList<MenuOption> searchMenuList;
    private static PhoneBookMenus phoneBookMenusInstance;

    /**
     * Private constructor for PhoneBookMenus
     * @param cm The ContactManager that manages the Database of Contacts
     */
    private PhoneBookMenus(ContactManager cm){
        this.cm = cm;
        fillEditMenu();
        fillMainMenu();
        fillSearchMenu();

    }

    /**
     * Method that returns the only instance of this class
     *
     * @return The one instance of class PhoneBookMenus
     */
    public static PhoneBookMenus newMenu(){
        if(phoneBookMenusInstance == null)
            phoneBookMenusInstance = new PhoneBookMenus(new ContactManager());
        return phoneBookMenusInstance;
    }


    /**
     * Method that initializes and adds all MenuOption-object
     * into arrayList mainMenuList
     *
     * This method is called from PhoneBookMenus-constructor
     */
    private void fillMainMenu(){
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new MenuOption("1. Add contact", () -> { cm.create(); mainMenu();} ));
        mainMenuList.add(new MenuOption("2. View/Edit contact", () -> {
            if (cm.findByList()) editMenu();
            mainMenu();
        }));
        mainMenuList.add(new MenuOption("3. Search contact", () -> searchMenu()));
        mainMenuList.add(new MenuOption("4. Exit", () -> {}));

    }
    /**
     * Private method that initializes and adds all MenuOption-object
     * into arrayList editMenuList
     *
     * This method is called from PhoneBookMenus-constructor only once
     */
    private void fillEditMenu(){
        editMenuList = new ArrayList<>();
        editMenuList.add(new MenuOption("1. Update name", () -> {cm.updateName(); editMenu();}));
        editMenuList.add(new MenuOption("2. Update phonenumber", () -> { cm.updatePhoneNumber(); editMenu();}));
        editMenuList.add(new MenuOption("3. Delete contact", () -> { cm.remove(); mainMenu();} ));
        editMenuList.add(new MenuOption("4. Back to main menu", () -> {}));

    }
    /**
     * Private method that initializes and adds all MenuOption-object
     * into arrayList searchMenuList
     *
     * This method is called from PhoneBookMenus-constructor only once
     */
    private void fillSearchMenu(){
        searchMenuList = new ArrayList<>();
        searchMenuList.add(new MenuOption("1. Search by name", () -> {if(cm.searchByName()) editMenu(); searchMenu();}));
        searchMenuList.add(new MenuOption("2. Search by Phonenumber", () -> { if(cm.searchByPhoneNumber()) editMenu(); searchMenu();}));
        searchMenuList.add(new MenuOption("3. Go back", () -> mainMenu()));

    }

    /**
     * Calls MenuReader.printMenu() with mainMenuList as argument and then MenuReader.executeMenu()
     * with mainMenuList and an int from UserInput as argument.
     * This loops through and executes the doSomething()-method attached to the chosen
     */
    public void mainMenu(){
       MenuReader.printMenu(mainMenuList);
       MenuReader.executeMenu(mainMenuList, UserInput.chooseFromList(mainMenuList));
    }

    /**
     * Calls MenuReader.printMenu() with editMenuList as argument and then MenuReader.executeMenu()
     * with editMenuList and an int from UserInput as argument.
     * This loops through and executes the doSomething()-method attached to the chosen
     */
    public void editMenu(){
        MenuReader.printMenu(editMenuList);
        MenuReader.executeMenu(editMenuList, UserInput.chooseFromList(editMenuList));
    }

    /**
     * Calls MenuReader.printMenu() with searchMenuList as argument and then MenuReader.executeMenu()
     * with searchMenuList and an int from UserInput as argument.
     * This loops through and executes the doSomething()-method attached to the chosen
     */
    public void searchMenu(){
        MenuReader.printMenu(searchMenuList);
        MenuReader.executeMenu(searchMenuList, UserInput.chooseFromList(searchMenuList));
    }

    /**
     *
     *
     * @return
     */
    public ArrayList<MenuOption> getMainMenuList(){
        ArrayList<MenuOption> menu = new ArrayList<>();
        menu.addAll(mainMenuList);
        return menu;
    }

    /**
     *
     *
     * @return
     */
    public ArrayList<MenuOption> getEditMenuList(){
        ArrayList<MenuOption> menu = new ArrayList<>();
        menu.addAll(editMenuList);
        return menu;
    }

    /**
     * //TODO write something generic hereeeeeee as desc
     * @return
     */
    public ArrayList<MenuOption> getSearchMenuList(){
        ArrayList<MenuOption> menu = new ArrayList<>();
        menu.addAll(searchMenuList);
        return menu;
    }



}
