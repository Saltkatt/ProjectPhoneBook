package userinteraction;

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

    public Menu(ContactManager cm, UserOutput out, UserInput in){
        this.cm = cm;
        this.in = in;
        this.out = out;
    }
}
