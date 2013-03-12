package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.model.person.Person;

//import domain.model.person.PersonIdentityMap;

public class PersonTDG extends TDG {
	
	private static PersonTDG instance = null;

	public PersonTDG() {
		SetBaseName();
		SetTable();
		SetInsert();
		SetUpdate();
		SetDelete();
		SetSelectAll();
		SetSelect();
	}

	public static PersonTDG getInstance() {
		if (instance == null) {
			instance = new PersonTDG();
		}
		return instance;
	}

	@Override
	public void SetBaseName() {
		BASE_NAME = "Person";
	}

	@Override
	public void SetInsert() {
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (email_address, first_name, last_name, date_of_birth, phone_number) VALUES (?,?,?,?,?);";
	}

	@Override
	public void SetUpdate() {
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.first_name=?, p.last_name=?, p.date_of_birth=?, p.phone_number=? WHERE p.email_address=?;";
	}

	@Override
	public void SetDelete() {
		DELETE = "DELETE p FROM " + TABLE + " AS p WHERE p.email_address=?;";
	}

	@Override
	public void SetSelectAll() {
		SELECT_ALL = "SELECT p.email_address, p.first_name, p.last_name, p.date_of_birth, p.phone_number FROM "
				+ TABLE + " AS p;";
	}

	@Override
	public void SetSelect() {
		SELECT = "SELECT p.email_address, p.first_name, p.last_name, p.date_of_birth, p.phone_number FROM "
				+ TABLE + " AS p WHERE p.email_address=?;";
	}

	@Override
	public PreparedStatement FillInsert(Object Obj, PreparedStatement ps) {
		Person person = (Person) Obj;
		try {
			ps.setString(1, person.getEmailAddress());
			ps.setString(2, person.getFirstName());
			ps.setString(3, person.getLastName());
			ps.setDate(4, person.getDOB());
			ps.setLong(5, person.getPhoneNumber());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PreparedStatement FillUpdate(Object Obj, PreparedStatement ps) {
		Person person = (Person) Obj;
		try {
			ps.setString(1, person.getFirstName());
			ps.setString(2, person.getLastName());
			ps.setDate(3, person.getDOB());
			ps.setLong(4, person.getPhoneNumber());
			ps.setString(5, person.getEmailAddress());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	public Object getObject(ResultSet rs)
	 {
		try {
			if(rs.next()){ 
				Person result = new Person(
				rs.getString("p.email_address"),
				rs.getString("p.first_name"),
				rs.getString("p.last_name"),
				rs.getDate("p.date_of_birth"),
				rs.getLong("p.phone_number")
				);				
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
	
	public List<Object> getAllObject(ResultSet rs)
	{
		List<Object> people = new ArrayList<Object>();
		try {
			while(rs.next()){ 
				Person result = (Person)getObject(rs);				
				people.add(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	 }
	
}
