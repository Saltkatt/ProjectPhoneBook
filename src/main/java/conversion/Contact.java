package conversion;

public class Contact {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    private String name;
    private String number;
    private String contactID;

    public Contact(){

    }

    public Contact(String contactId, String name, String number){
        this.name = name;
        this.number = number;
        this.contactID = contactId;
    }
}
