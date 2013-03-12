package domain.model.person;

import java.sql.Date;

public class Visitor extends Person{

	public Visitor(String email_address, String password, String first_name, String last_name, Date date_of_birth, long phone_number)
	{super(email_address, first_name, last_name, date_of_birth, phone_number);}
}
