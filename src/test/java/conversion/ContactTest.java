package conversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void getNameTest() {
        Contact c = new Contact("Göran", "0453453475834");
        assertEquals("Göran", c.getName());
        c = new Contact("Leif", "8489898989");
    }

    @Test
    void setNameTest() {
        Contact c = new Contact("Bosse", "4534534");
        c.setName("Göran");
        assertEquals("Göran", c.getName());
        c.setName(" ");
        assertEquals(" ", c.getName());
    }

    @Test
    void getNumberTest() {
        Contact c = new Contact("Bosse", "031493283");
        assertEquals("031493283", c.getNumber());
        c = new Contact("Wow", "4545454");
        assertEquals("4545454", c.getNumber());
    }

    @Test
    void toStringTest() {
        Contact c = new Contact("Daniella", "1234");
        assertEquals("Contact[Name=Daniella, Number=1234]", c.toString());
    }

    @Test
    void setNumberTest() {
        Contact c = new Contact("Bosse", "123456789");
        c.setNumber("112");
        assertEquals("112", c.getNumber());
    }

    @Test
    void getContactIDTest() {
        Contact.reset();
        Contact c = new Contact("Daniella", "112");
        assertEquals(1, c.getContactID());
        Contact c2 = new Contact("Bosse", "1234");
        assertEquals(2, c2.getContactID());
        Contact c3 = new Contact("A", "123");
        Contact c4 = new Contact("Woah", "123");
        assertEquals(1, c.getContactID());
        assertEquals(3, c3.getContactID());
        assertEquals(4, c4.getContactID());
        Contact.reset();
        Contact c5 = new Contact("Bosse igen", "1234");
        assertEquals(1, c5.getContactID());
    }

}