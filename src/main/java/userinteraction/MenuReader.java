package userinteraction;

import java.util.List;

/**
 * Class that has static methods to loop´through a list of MenuOption
 * and execute the DoSomething-method in the MenuOption.
 *
 * @author Daniella Norén
 * @version 1.0 Build 2018
 *
 */

public class MenuReader {

    /**
     * Loops through and sends each MenuOption of a non-empty MenuOption-list to UserOutput
     * that prints the MenuText belonging to that MenuOption in order.
     *
     * @param list List of MenuOptions whose MenuTexts you want printed on screen
     */
    public static void printMenu(List<MenuOption> list){
        if(list.size() > 0){
            list.forEach(e -> UserOutput.printLine(e.getMenuText()));
        }else
            throw new IllegalArgumentException();
    }

    /**
     * Executes the DoSomething-method of a MenuOption-object
     * in a list.
     *
     * @param list The list of MenuOptions
     * @param choice The position of the MenuOptions on the list
     */
    public static void executeMenu(List<MenuOption> list, int choice){
        if(choice >= list.size() || choice < 0)
            throw new IllegalArgumentException();
        list.get(choice).getDoIt().doThing();
    }




}
