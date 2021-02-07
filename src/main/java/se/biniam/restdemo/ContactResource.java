package se.biniam.restdemo;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// the path that connect with web browser
@Path("contact")
public class ContactResource {
	
	//we can change from sql to normal data
	ContactRepositorySql repo=new ContactRepositorySql();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Contact> getContact() {
		System.out.println("contact is called");
		
		return repo.getContact();
	}
	@GET
	@Path("contacts/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Contact getContact(@PathParam("id") int id) {
		System.out.println("contact is called");
		
		return repo.getContact(id);
	}
	
	@POST
	@Path("Contacts")
	//@Consumes(MediaType.APPLICATION_XML)//this method only takes Json Format or xml  format according to our needs.
	public Contact createContact(Contact c) {
		System.out.println(c);
		repo.create(c);
		return c;
		
		
	
		
	}

}
