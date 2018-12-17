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

    public String getId(){return id;}

//    @Override
//    public String toString() {
//        return "Contact{" +
//                "name='" + name + '\'' +
//                ", number='" + number + '\'' +
//                '}';
//    }

    public void setNumber(String number) {
        this.number = number;
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
