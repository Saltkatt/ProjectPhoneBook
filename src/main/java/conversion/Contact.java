package conversion;

/**
 *Class representing a contact in the phone book
 *It holds a name, phone number and an ID
 *
 * @author Daniella Norén
 * @version 1 Build 2018
 */
public class Contact {


    private String id;
    private String name;
    private String number;

    /**
     * Constructor for Contact
     *
     * @param id The ID of the contact
     * @param name The name of the contact
     * @param number The phone number of the contact
     */
    public Contact(String id, String name, String number){
        if(name.matches("^[a-zåäöA-ZÅÄÖ]{1,30}$"))
            this.name = name;
        else
            throw new IllegalArgumentException();
        this.id = id;
        if(number.matches("^[0-9]{1,20}$"))
            this.number = number;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Gets the ID of the contact
     * @return int ID of contact
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name of the contact
     * @param name The new name of the contact
     */
    public void setName(String name) {
        if(name.matches("^[a-zåäöA-ZÅÄÖ]{1,30}$"))
            this.name = name;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Returns the number of the contact
     * @return Number of contact
     */
    public String getNumber() {
        return number;
    }

    public String getId(){return id;}

    /**
     * Returns a String representing the Contact
     *
     * @return String of
     */
    @Override
    public String toString() {
        return "Contact[" +
                "Name=" + name +
                ", Number=" + number +
                ", ID="+id+
                ']';
    }

    /**
     * Sets a new number of the contact
     * @param number New number of contact
     */
    public void setNumber(String number) {
        if(number.matches("^[0-9]{1,20}$"))
            this.number = number;
        else
            throw new IllegalArgumentException();
    }

}
