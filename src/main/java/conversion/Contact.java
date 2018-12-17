package conversion;

/**
 * Class to represent a Contact in the database
 * This is only used when delaing with JavaFX
 *
 * @author Daniella Norén
 * @version 1 Build 2018
 */
public class Contact {

    private String name;
    private String number;
    private int contactID;
    private static int contactCount;

    /**
     * Constructor for Contact
     *
     * The contactID gets generated automatically in here, the static contactCount-variable
     * keeps track of how many contacts have been created and that number becomes the contactID
     * for the specific contact being created
     *
     * @param name The name of the contact
     * @param number The phone number of the contact
     */
    public Contact(String name, String number){
        this.name = name;
        if(number.length() <= 20 && number.matches("[0-9]+"))
            this.number = number;
        else
            throw new IllegalArgumentException();
        contactID = contactCount;
        contactCount++;
    }

    /**
     * Returns the name of the contact
     * @return String name of contact
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name of the contact
     * @param name The new name of the contact
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of the contact
     * @return Number of contact
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets a new number of the contact
     * @param number New number of contact
     */
    public void setNumber(String number) {
        if(number.length() <= 20 && number.matches("[0-9]+"))
            this.number = number;
        else
            throw new IllegalArgumentException();
    }

    /**
     * Gets the ID of the contact
     * @return int ID of contact
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * Returns a String representing the Contact
     *
     * @return String of
     */
    @Override
    public String toString() {
        return "Contact[Name=" +
                name + ", Number="+ number +
                ", ID="+contactID+']';
    }

    /**
     * Resets the ContactCounter to 1.
     * Use eg this when wanting to start over after deleting all your contacts
     * Next created Contact will then have contactID 1 etc.
     */
    public static void reset(){
        contactCount = 1;
    }


}
