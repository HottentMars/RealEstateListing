package domain.model.person;

import java.sql.Date;

public class Person {
	private long id;
	private int version;
	private String email_address;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private long phone_number;
	
	public Person()
	{}
	
	public Person(long id, int version, String email_address, String first_name, String last_name, Date date_of_birth, long phone_number) {
		this.id = id;
		this.version = version;
		this.email_address=email_address;
		this.first_name=first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.phone_number = phone_number;
	}
	
	public long getId() {
		return id;
	}	

	public int getVersion() {
		return version;
	}
	
	public String getEmailAddress() {
		return email_address;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public Date getDOB() {
		return date_of_birth;
	}
	
	public long getPhoneNumber() {
		return phone_number;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public void setEmailAddress(String email_address) {
		this.email_address = email_address;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public void setDOB(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public void setPhoneNumber(long phone_number) {
		this.phone_number = phone_number;
	}
}
	
	
