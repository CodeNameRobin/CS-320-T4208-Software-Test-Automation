package ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

	private static String uniqueId = null;
	private List<Contact> contactList = new ArrayList<>();
	
	public void newContact() {
	    Contact contact = new Contact(newUniqueId());
	    contactList.add(contact);
	}
	
	public void newContact(String firstName) { 
		Contact contact = new Contact(newUniqueId(), firstName); 
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName) { 
		Contact contact = new Contact(newUniqueId(), firstName, lastName); 
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phoneNume) { 
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNume); 
		contactList.add(contact);
	}
	
	public void newContact(String firstName, String lastName, String phoneNume, String address) { 
		Contact contact = new Contact(newUniqueId(), firstName, lastName, phoneNume, address); 
		contactList.add(contact); 
	}
	
	
	private String newUniqueId() {
		
		if(uniqueId == null) {
			uniqueId = UUID.randomUUID().toString().substring(0, (int)(Math.random() * (11-1+1) + 1));
			uniqueId = uniqueId.replace("-", "");
		}
		for(int i = 0; i < contactList.size(); i++) {
			if(uniqueId.equals(getContactList().get(i).getContactId())){
				uniqueId = UUID.randomUUID().toString().substring(0, (int)(Math.random() * (11-1+1) + 1));
				uniqueId = uniqueId.replace("-", "");
				i = 0;
			}
		}
	    System.out.println(uniqueId);
    	
	    return uniqueId;	
	  }
	
	public void deleteContact(String contactId) throws Exception {
	    contactList.remove(searchForContact(contactId));
	  }
	
	
	private int searchForContact(String contactId) throws Exception {
		int currIndex = 0;
		while(currIndex < getContactList().size()) {
			for(currIndex = 0; currIndex < getContactList().size(); currIndex++) {
				if(contactId.equals(getContactList().get(currIndex).getContactId())) {
					return currIndex;
				}
			}
		}
		throw new Exception("That contact does not exist!");
	}



	protected List<Contact> getContactList() { return contactList; }
}
