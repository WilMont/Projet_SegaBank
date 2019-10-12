package book.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Book implements Serializable {
	
	private String name;
	private List<Contact> contacts;
	
	public Book( String name ) {
		this.name = name;
		contacts = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts( List<Contact> contacts ) {
		this.contacts = contacts;
	}
	
	public void addContact(Contact contact) {
		contacts.add( contact );
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "Book{" );
		sb.append( "name='" ).append( name ).append( '\'' );
		sb.append( ", contacts=" ).append( contacts );
		sb.append( '}' );
		return sb.toString();
	}
}
