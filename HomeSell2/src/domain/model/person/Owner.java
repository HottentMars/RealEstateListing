package domain.model.person;

import java.sql.Date;

public class Owner extends Person {

	private int ownerVersion;
	private String password;
	
	public Owner(long id, int personVersion, String email_address, String first_name, String last_name, Date date_of_birth, long phone_number, int ownerVersion, String password){
		super(id, personVersion, email_address, first_name, last_name, date_of_birth, phone_number);
		this.ownerVersion = ownerVersion;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getOwnerVersion() {
		return ownerVersion;
	}

	public void setOwnerVersion(int ownerVersion) {
		this.ownerVersion = ownerVersion;
	}
	
}
