package conversion;

public class Contact {

    private String name;
    private String number;
    private int contactID;
    private static int contactCount;

    public Contact(String name, String number){
        this.name = name;
        if(number.length() <= 20 && number.matches("[0-9]+"))
            this.number = number;
        contactID = contactCount;
        contactCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getContactID() {
        return contactID;
    }


    @Override
    public String toString() {
        return "Contact[Name=" +
                name + ", Number="+ number + ']';
    }

    public static void reset(){
        contactCount = 1;
    }


}
