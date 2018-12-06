package userinteraction;

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
