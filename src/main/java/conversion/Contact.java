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



    private String name;
    private String number;

    public Contact(String name, String number){
        this.name = name;
        this.number = number;
    }
}
