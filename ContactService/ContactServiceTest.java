package ContactService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AppointmentService.AppointmentService;

public class ContactServiceTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest;
	protected String tooLongFirstNameTest, tooLongLastNameTest, tooShortNumTest, tooLongNumTest, tooLongAddressTest;
	
	@BeforeEach
	void setUp() {
		contactId = "MF6VOM9Z";
		firstNameTest = "John";
		lastNameTest = "Smith";
		phoneNumTest = "5091234567";
		addressTest = "3205 S University Rd WA 99206";
		tooLongFirstNameTest = "MoreThenTenLetterName";
		tooLongLastNameTest = "MoreThenTenLetterLastName";
		tooShortNumTest = "12345";
		tooLongNumTest = "123456789123";
		tooLongAddressTest = "12345 Too Long Addres 12345 Too Long Addres 12345 Too Long Addres";
	}
	
	@Test
	void newContactTest() {
	    ContactService service = new ContactService();
	    service.newContact();
	    
	    assertAll(
		        "service",
		        	() -> assertNotNull(service.getContactList().get(0).getContactId()),
		        	() -> assertEquals("INITAL", service.getContactList().get(0).getFirstName()),
		        	() -> assertEquals("INITAL", service.getContactList().get(0).getLastName()),
		        	() -> assertEquals("0123456789", service.getContactList().get(0).getPhoneNum()),
		        	() -> assertEquals("INITAL", service.getContactList().get(0).getAddress()));
	    			
	    service.newContact(firstNameTest);
	    //System.out.println(service.getContactList().get(0).getFirstName());
	    
	    assertAll(
		        "service",
		        	() -> assertNotNull(service.getContactList().get(1).getContactId()),
		        	() -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
		        	() -> assertEquals("INITAL", service.getContactList().get(1).getLastName()),
		        	() -> assertEquals("0123456789", service.getContactList().get(1).getPhoneNum()),
		        	() -> assertEquals("INITAL", service.getContactList().get(1).getAddress()));
	    	
	    			
	    service.newContact(firstNameTest, lastNameTest); 
	    //System.out.println(service.getContactList().get(1).getFirstName() + " " + service.getContactList().get(1).getLastName());
	    
	    assertAll(
		        "service",
		        	() -> assertNotNull(service.getContactList().get(2).getContactId()),
		        	() -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
		        	() -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
		        	() -> assertEquals("0123456789", service.getContactList().get(2).getPhoneNum()),
		        	() -> assertEquals("INITAL", service.getContactList().get(2).getAddress()));
	    			
	    service.newContact(firstNameTest, lastNameTest, phoneNumTest);
	    //System.out.println(service.getContactList().get(1).getFirstName() + " " + service.getContactList().get(2).getLastName() + " " + service.getContactList().get(0).getPhoneNum());
	    
	    assertAll(
		        "service",
		        	() -> assertNotNull(service.getContactList().get(3).getContactId()),
		        	() -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
		        	() -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
		        	() -> assertEquals(phoneNumTest, service.getContactList().get(3).getPhoneNum()),
		        	() -> assertEquals("INITAL", service.getContactList().get(3).getAddress()));
	    			
	    service.newContact(firstNameTest, lastNameTest, phoneNumTest, addressTest);
	    //System.out.println(service.getContactList().get(3).getFirstName() + " " + service.getContactList().get(3).getLastName() + " " + service.getContactList().get(3).getPhoneNum());
	
	    assertAll(
		        "service",
		        	() -> assertNotNull(service.getContactList().get(4).getContactId()),
		        	() -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
		        	() -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
		        	() -> assertEquals(phoneNumTest, service.getContactList().get(4).getPhoneNum()),
		        	() -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
	    			
	    //service.newContact(firstNameTest, lastNameTest, phoneNumTest, addressTest);
	}
	
	
	@Test
	  void newContactTooLongFirstNameTest() {
		ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newContact(tooLongFirstNameTest, lastNameTest, phoneNumTest, addressTest));
	  }
	
	@Test
	  void newContactTooLongLastNameTest() {
		ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newContact(firstNameTest, tooLongLastNameTest, phoneNumTest, addressTest));
	  }
	
	@Test
	  void newContactTooShortNumTest() {
		ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newContact(firstNameTest, lastNameTest, tooShortNumTest, addressTest));
	  }
	
	@Test
	  void newContactTooLongNumTest() {
		ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newContact(firstNameTest, lastNameTest, tooLongNumTest, addressTest));
	  }
	
	@Test
	  void newContactTooLongAddressTest() {
		ContactService service = new ContactService();
	    assertThrows(IllegalArgumentException.class,
	                 () -> service.newContact(firstNameTest, lastNameTest, phoneNumTest, tooLongAddressTest));
	  }

}
