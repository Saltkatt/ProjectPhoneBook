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
    private static ArrayList<MenuOptions> mainMenuList;
    private static ArrayList<MenuOptions> editMenuList;
    private static ArrayList<MenuOptions> searchMenuList;
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
     * Method that initializes and adds all MenuOptions-object
     * into arrayList mainMenuList
     *
     * This method is called from PhoneBookMenus-constructor
     */

    private void fillMainMenu(){
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new MenuOptions("1. Add contact", () -> { cm.create(); mainMenu();} ));
        mainMenuList.add(new MenuOptions("2. View/Edit contact", () -> {
            if (cm.findByList()) editMenu();
            mainMenu();
        }));
        mainMenuList.add(new MenuOptions("3. Search contact", () -> searchMenu()));
        mainMenuList.add(new MenuOptions("4. Exit", () -> {}));

    }
    /**
     * Method that initializes and adds all MenuOptions-object
     * into arrayList editMenuList
     *
     * This method is called from PhoneBookMenus-constructor
     */

    private void fillEditMenu(){
        editMenuList = new ArrayList<>();
        editMenuList.add(new MenuOptions("1. Update name", () -> {cm.updateName(); editMenu();}));
        editMenuList.add(new MenuOptions("2. Update phonenumber", () -> { cm.updatePhoneNumber(); editMenu();}));
        editMenuList.add(new MenuOptions("3. Delete contact", () -> { cm.remove(); mainMenu();} ));
        editMenuList.add(new MenuOptions("4. Back to main menu", () -> {}));

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
       MenuReader.printMenu(mainMenuList);
       MenuReader.executeMenu(mainMenuList, UserInput.chooseFromList(mainMenuList));
    }
    /**
     * Calls readMenu(ArrayList<> list) with editMenuList as argument
     */
    public void editMenu(){
        MenuReader.printMenu(editMenuList);
        MenuReader.executeMenu(editMenuList, UserInput.chooseFromList(editMenuList));
    }

    public void searchMenu(){
        MenuReader.printMenu(searchMenuList);
        MenuReader.executeMenu(searchMenuList, UserInput.chooseFromList(searchMenuList));
    }



}