package ContactService;

public class Contact {
	private int SHORT_LENGTH = 10;
	private int LONG_LENGTH = 30;
	private String INIT_STRING = "INITAL";
	private String INIT_NUM = "0123456789";
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	
	Contact() {
	    this.contactId = INIT_STRING;
	    this.firstName = INIT_STRING;
	    this.lastName = INIT_STRING;
	    this.phoneNum = INIT_NUM;
	    this.address = INIT_STRING;
	}
	Contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INIT_STRING;
	    this.lastName = INIT_STRING;
	    this.phoneNum = INIT_NUM;
	    this.address = INIT_STRING;
	}
	
	Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INIT_STRING;
	    this.phoneNum = INIT_NUM;
	    this.address = INIT_STRING;
	}
	
	Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNum = INIT_NUM;
	    this.address = INIT_STRING;
	}
	
	Contact(String contactId, String firstName, String lastName, String phoneNum) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNum(phoneNum);
	    this.address = INIT_STRING;
	}
	
	Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNum(phoneNum);
	    updateAddress(address);
	}	
	
	protected void updateContactId(String contactId) {
		if (contactId == null) {
		      throw new IllegalArgumentException("Contact ID is empty!");
		    } else if (contactId.length() > SHORT_LENGTH) {
		      throw new IllegalArgumentException("Contact ID cannot exceed " +
		                                         SHORT_LENGTH + " characters");
		    } else {
		      this.contactId = contactId;
		    }
	}
	
	protected void updateFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("First name not entered!");
	    } else if (firstName.length() > SHORT_LENGTH) {
	      throw new IllegalArgumentException("First name cannot exceed " + SHORT_LENGTH + " characters");
	    } else {
	      this.firstName = firstName;
	    }
	  }
	
	protected void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Last name not entered!");
	    } else if (lastName.length() > SHORT_LENGTH) {
	      throw new IllegalArgumentException("Last name cannot exceed " + SHORT_LENGTH + " characters");
	    } else {
	      this.lastName = lastName;
	    }
	  }
	
	protected void updatePhoneNum(String phoneNum) {
	    if (phoneNum == null) {
	      throw new IllegalArgumentException("Phone number name not entered!");
	    } else if (phoneNum.length() != SHORT_LENGTH) {
	      throw new IllegalArgumentException("Phone number must be exactly " + SHORT_LENGTH + " numbers");
	    } else {
	      this.phoneNum = phoneNum;
	    }
	  }
	
	protected void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address not entered!");
	    } else if (address.length() > LONG_LENGTH) {
	      throw new IllegalArgumentException("Adress cannot exceed " + LONG_LENGTH + " characters");
	    } else {
	      this.address = address;
	    }
	  }
	
	public final String getContactId() { return contactId; }
	public final String getFirstName() { return firstName; }
	public final String getLastName() { return lastName; }
	public final String getPhoneNum() { return phoneNum; }
	public final String getAddress() { return address; }
	
	

}
