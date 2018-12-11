package userinteraction;

import java.util.ArrayList;

public class MenuReader {

    public void printMenu(ArrayList<MenuOptions> list){
        if(list.size() > 0){
            list.forEach(e -> UserOutput.printLine(e.getMenuText()));
        }
    }
    public void executeMenu(ArrayList<MenuOptions> list, int choice){
        list.get(choice).getDoIt().doThing();
    }


}
