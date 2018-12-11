package userinteraction;

import java.util.ArrayList;

public class MenuReader {

    public static void printMenu(ArrayList<MenuOptions> list){
        if(list.size() > 0){
            list.forEach(e -> UserOutput.printLine(e.getMenuText()));
        }
    }
    public static void executeMenu(ArrayList<MenuOptions> list, int choice){
        list.get(choice).getDoIt().doThing();
    }
    public static void readAndExecuteMenu(ArrayList<MenuOptions> list, int choice){
        printMenu(list);
        executeMenu(list, choice);
    }



}
