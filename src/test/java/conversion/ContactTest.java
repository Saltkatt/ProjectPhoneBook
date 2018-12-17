package conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass for Contact
 *
 * This class tests so that the Contact-class works
 *
 * @author Daniella Norén
 * @version 1 Build 2018
 */
class ContactTest {

    /**
     * When creating a new Contact, the number should be less than 20 numbers,
     * only numbers and not letters or other characters.
     *
     * Contact should get a contactID automatically
     */
    @Test
    void createContactTest(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("Daniella", "123456789123456789123"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("Bosse", "hej"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("Bosse", "-3"));
        Contact c = new Contact("Daniella", "3545");
        assertEquals("Daniella", c.getName());
        assertEquals("3545", c.getNumber());
        assertEquals(1, c.getContactID());

    }

    /**
     * Check so that the getName() method returns the
     * name user put in when creating contact
     */
    @Test
    void getNameTest() {
        Contact c = new Contact("Göran", "0453453475834");
        assertEquals("Göran", c.getName());
        c = new Contact("Leif", "8489898989");
    }

    /**
     * Test so that the setName()-method changes the name
     * from the old name to new name
     */
    @Test
    void setNameTest() {
        Contact c = new Contact("Bosse", "4534534");
        c.setName("Göran");
        assertEquals("Göran", c.getName());
        c.setName(" ");
        assertEquals(" ", c.getName());
    }

    /**
     * Test so that getNumber() returns
     * the correct number
     */
    @Test
    void getNumberTest() {
        Contact c = new Contact("Bosse", "031493283");
        assertEquals("031493283", c.getNumber());
        c = new Contact("Wow", "4545454");
        assertEquals("4545454", c.getNumber());
    }

    /**
     * Test so that the toString()-method returns
     * a String in the correct format
     */
    @Test
    void toStringTest() {
        Contact c = new Contact("Daniella", "1234");
        assertEquals("Contact[Name=Daniella, Number=1234, ID=1]", c.toString());
    }

    /**
     * Test to make sure that the setNumber()-method
     * throws IllegalArgument when given illegal number and when given
     * correct number it updates the contact
     */
    @Test
    void setNumberTest() {
        Contact c = new Contact("Bosse", "123456789");
        c.setNumber("112");
        assertEquals("112", c.getNumber());
        assertThrows(IllegalArgumentException.class, () -> c.setNumber("123456789123456789122"));
    }

    /**
     * Check so that every contact gets a contactID automatically and that it
     * increases by every contact added.
     */
    @Test
    void getContactIDTest() {
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

    /**
     * Before every test, reset the contactCounter to 1
     */
    @BeforeEach
    void resetContactIDcount(){
        Contact.reset();
    }

}