package userinteraction;

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
