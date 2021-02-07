package se.biniam.restdemo;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
	
	List<Contact> contacts;
	public ContactRepository() {
		contacts=new ArrayList<>();
		
		
		Contact a1=new Contact();
		a1.setId(1);
		a1.setName("Biniam");
		a1.setPoint(80);
		
		Contact a2=new Contact();
		a2.setId(2);
		a2.setName("Biniam");
		a2.setPoint(80);
		contacts.add(a1);
		contacts.add(a2);
	}
	
	public List<Contact> getContact(){
		
		return contacts;
	}
 public Contact getContact(int id) {
	for(Contact c: contacts)
	{
		if(c.getId()==id)
			return c;
	}
	 return null;
 }

public void create(Contact c) {
	contacts.add(c);
	
}
}
