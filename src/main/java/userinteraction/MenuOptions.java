package userinteraction;

/**
 *
 *
 *Instances of this class is intended to be used
 * in an ArrayList of type MenuOptions,
 * but can be used outside one as well.
 *
 * @author Daniella Norén
 * @version version 0.1 Build Dec 06 2018
 */

public class MenuOptions {

    private DoSomething doIt;
    private String menuText;

    /**
     *Constructor of MenuOptions
     *
     * @param menuText Text of the menu-option, eg "1. Add contact" or "Enter name: "
     * @param method An implementation of functional Interface DoSomething. Override void method doThing() with
     *               whatever method you please. Should correspond to the PhoneBookMenus Text
     */
    public MenuOptions(String menuText, DoSomething method){
        if(menuText.isEmpty())
            throw new IllegalArgumentException("Enter text");
        this.menuText = menuText;
        this.doIt = method;
    }

    /**
     *
     * @return Returns the instance of the DoSomething-interface, which you can run your custom doThing()-method on
     */
    public DoSomething getDoIt(){
        return doIt;
    }

    /**
     *
     * @return Returns the text of your PhoneBookMenus-option
     */
    public String getMenuText(){
        return menuText;
    }
}
