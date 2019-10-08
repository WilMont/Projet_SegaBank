package book.bo;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Serializable, Comparable<Contact> {
	
	public enum Gender {
		M("Male") , F("Female");
		
		private String label;
		
		Gender( String label ) {
			this.label = label;
		}
		
		public String getLabel() {
			return label;
		}
		
		public void setLabel( String label ) {
			this.label = label;
		}
	}
	private int id;
	private String name;
	private String email;
	private Gender gender;
	
	public Contact() {}
	
	public Contact( String name, String email ) {
		this.name = name;
		this.email = email;
	}
	
	public Contact( String name, String email, Gender gender ) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId( int id ) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName( String name ) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail( String email ) {
		this.email = email;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender( Gender gender ) {
		
		this.gender = gender;
	}
	
	@Override
	public boolean equals( Object o ) {
		if ( this == o ) return true;
		if ( !(o instanceof Contact) ) return false;
		Contact contact = ( Contact ) o;
		return Objects.equals( name, contact.name ) && Objects.equals( email, contact.email );
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash( name, email );
	}
	
	@Override
	public int compareTo( Contact other ) {
		return name.compareTo( other.getName() );
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "Contact{" );
		sb.append( "id=" ).append( id );
		sb.append( ", name='" ).append( name ).append( '\'' );
		sb.append( ", email='" ).append( email ).append( '\'' );
		sb.append( ", gender=" ).append( gender );
		sb.append( '}' );
		return sb.toString();
	}
}
