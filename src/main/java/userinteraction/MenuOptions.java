package userinteraction;

/**
 *This class is used for menuoptions.
 * The String menuText is the text and the
 * DoSomething is a functional interface whose
 * method you create corresponds to the text.
 * Eg, "1. Say hello", () -> Person.sayHello().
 *
 * @author Daniella Norén
 * @version version 0.1 Dec 06 2018
 */

public class MenuOptions {

    private DoSomething doIt;
    private String menuText;

    public MenuOptions(String menuText, DoSomething method){
        this.menuText = menuText;
        this.doIt = method;
    }

    public DoSomething getDoIt(){
        return doIt;
    }
    public String getMenuText(){
        return menuText;
    }
}
