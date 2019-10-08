package book.bo;

import java.util.Comparator;

public class ContactEmailComparator implements Comparator<Contact> {
	@Override
	public int compare( Contact contact1, Contact contact2 ) {
		return contact1.getEmail().compareTo( contact2.getEmail() );
	}
}
