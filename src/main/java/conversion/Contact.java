package conversion;

public class Contact {

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

    public String getId(){return id;}

    /**
     * Returns a String representing the Contact
     *
     * @return String of
     */
    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    /**
     * Sets a new number of the contact
     * @param number New number of contact
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets the ID of the contact
     * @return int ID of contact
     */
    public String getContactID() {
        return contactID;
    }

    private String id;
    private String name;
    private String number;

    public Contact(String id, String name, String number){
        this.id = id;
        this.name = name;
        this.number = number;
    }
}
