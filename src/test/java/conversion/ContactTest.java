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
     */

    @Test
    void createContactTest() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Daniella", "123456789123456789123"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("2", "Bosse", "hej"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("3", "Bosse", "-3"));
        Contact c = new Contact("1", "Daniella", "3545");
        assertEquals("Daniella", c.getName());
        assertEquals("3545", c.getNumber());
        assertEquals("1", c.getId());

    }

    /**
     * Check so that the getName() method returns the
     * name user put in when creating contact
     */
    @Test
    void getNameTest() {
        Contact c = new Contact("1","Göran", "0453453475834");
        assertEquals("Göran", c.getName());
        c = new Contact("4", "Leif", "8489898989");
        assertEquals("Leif", c.getName());
    }

    /**
     * Test so that the setName()-method changes the name
     * from the old name to new name
     */
    @Test
    void setNameTest() {
        Contact c = new Contact("4","Bosse", "4534534");
        c.setName("Göran");
        assertEquals("Göran", c.getName());
        assertThrows(IllegalArgumentException.class, () -> c.setName(" "));
    }

    /**
     * Test so that getNumber() returns
     * the correct number
     */
    @Test
    void getNumberTest() {
        Contact c = new Contact("1","Bosse", "031493283");
        assertEquals("031493283", c.getNumber());
        c = new Contact("2","Wow", "4545454");
        assertEquals("4545454", c.getNumber());
    }

    /**
     * Test so that the toString()-method returns
     * a String in the correct format
     */
    @Test
    void toStringTest() {
        Contact c = new Contact("1","Daniella", "1234");
        assertEquals("Contact[Name=Daniella, Number=1234, ID=1]", c.toString());
    }

    /**
     * Test to make sure that the setNumber()-method
     * throws IllegalArgument when given illegal number and when given
     * correct number it updates the contact
     */
    @Test
    void setNumberTest() {
        Contact c = new Contact("1","Bosse", "123456789");
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
        Contact c = new Contact("1","Daniella", "112");
        assertEquals("1", c.getId());
        Contact c2 = new Contact("2","Bosse", "1234");
        assertEquals("2", c2.getId());
        Contact c3 = new Contact("5","A", "123");
        Contact c4 = new Contact("6","Woah", "123");
        assertEquals("1", c.getId());
        assertEquals("5", c3.getId());
        assertEquals("6", c4.getId());
        Contact c5 = new Contact("4","Bosseigen", "1234");
        assertEquals("4", c5.getId());
    }


    }