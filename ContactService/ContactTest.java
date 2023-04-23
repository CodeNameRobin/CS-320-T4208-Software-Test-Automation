package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContactTest {
	protected String contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest;
	protected String tooLongFirstNameTest, tooLongLastNameTest, tooShortNumTest, tooLongNumTest, tooLongAddressTest;

	@BeforeEach
	void setUp() {
		contactId = "MF6VOM9Z";
		firstNameTest = "John";
		lastNameTest = "Smith";
		phoneNumTest = "5091234567";
		addressTest ="3205 S University Rd WA 99206";
		tooLongFirstNameTest = "MoreThenTenLetterName";
		tooLongLastNameTest = "MoreThenTenLetterLastName";
		tooShortNumTest = "12345";
		tooLongNumTest = "123456789123";
		tooLongAddressTest = "12345 Too Long Addres 12345 Too Long Addres 12345 Too Long Addres";
		//System.out.print(contactId );
	}
	
	
	
	@Test
	void contactTest() {
	    Contact contact = new Contact();
	    //System.out.println("Words " + contact.getContactId() + " " + contact.getFirstName());
	    assertAll("constructor",
	              () -> assertNotNull(contact.getContactId()),
	              () -> assertNotNull(contact.getFirstName()),
	              () -> assertNotNull(contact.getLastName()),
	              () -> assertNotNull(contact.getPhoneNum()),
	              () -> assertNotNull(contact.getAddress()));
	}
	
	@Test 
	 void contactIdConstructorTest() {
		Contact contact = new Contact(contactId); 
		assertAll("constructor one", 
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNum()),
				() -> assertNotNull(contact.getAddress()));
		//System.out.println(contactId + " " + contact.getContactId() + " " + contact.getFirstName());
	}
	
	@Test 
	void contactIdAndFirstNameTest() {
		Contact contact = new Contact(contactId, firstNameTest);
		assertAll("constructor two",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNum()),
				() -> assertNotNull(contact.getAddress()));
		//System.out.println(contactId + " " + contact.getContactId() + " " + contact.getFirstName() + " " + contact.getLastName());
	}
	
	@Test 
	void contactIdAndWholeNameTest() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
		assertAll("constructor three",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNum()),
				() -> assertNotNull(contact.getAddress()));
		//System.out.println(contact.getContactId() + " " + contact.getFirstName() + " " + contact.getLastName() + " " + contact.getPhoneNum());
	}
	
	@Test 
	void contactIdWholeNameAndNumberTest() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest);
		assertAll("constructor four",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertEquals(phoneNumTest, contact.getPhoneNum()),
				() -> assertNotNull(contact.getAddress()));
		//System.out.println(contact.getAddress() + " " + contact.getFirstName() + " " + contact.getLastName() + " " + contact.getPhoneNum());
	}
	
	@Test 
	void contactIdWholeNameNumberAndAddressTest() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumTest, addressTest);
		assertAll("constructor five",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstNameTest, contact.getFirstName()),
				() -> assertEquals(lastNameTest, contact.getLastName()),
				() -> assertEquals(phoneNumTest, contact.getPhoneNum()),
				() -> assertEquals(addressTest, contact.getAddress()));
		//System.out.println(contactId + " " + contact.getContactId() + " " + contact.getFirstName() + " " + contact.getLastName());
	}
	
}
