package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.model.person.*;

public class OwnerTDG extends TDG{
	
	public OwnerTDG()
	{
		SetBaseName();
		SetTable();
		SetInsert();
		SetUpdate();
		SetDelete();
		SetSelectAll();
		SetSelect();
	}
	
	@Override
	public void SetBaseName() {
		// TODO Auto-generated method stub
		BASE_NAME = "Owner";
	}

	@Override
	public void SetInsert() {
		// TODO Auto-generated method stub
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (email_address, password) VALUES (?,?);";
	}

	@Override
	public void SetUpdate() {
		// TODO Auto-generated method stub
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.password=? WHERE p.email_address=?;";
	}

	@Override
	public void SetDelete() {
		// TODO Auto-generated method stub
		DELETE = "DELETE p FROM " + TABLE + " AS p WHERE p.email_address=?;";
	}

	@Override
	public void SetSelectAll() {
		// TODO Auto-generated method stub
		SELECT_ALL = "SELECT p.email_address, p.password FROM "
				+ TABLE + " AS p;";
	}

	@Override
	public void SetSelect() {
		// TODO Auto-generated method stub
		SELECT = "SELECT p.email_address, p.password FROM "
				+ TABLE + " AS p WHERE p.email_address=?;";
	}

	@Override
	public Object getObject(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(rs.next()){
				TDG Another = new PersonTDG();
				Person ThePerson = (Person)Another.find(rs.getString("p.email_address"));
				Owner result = new Owner(
				rs.getString("p.email_address"),
				rs.getString("p.password"),
				ThePerson.getFirstName(),
				ThePerson.getLastName(),
				ThePerson.getDOB(),
				ThePerson.getPhoneNumber()
				);				
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object> getAllObject(ResultSet rs) {
		// TODO Auto-generated method stub
		List<Object> people = new ArrayList<Object>();
		
		try {
			
			while(rs.next()){ 
				if(rs.previous());
				Owner result = (Owner)getObject(rs);				
				people.add(result);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}

	@Override
	public PreparedStatement FillInsert(Object Obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		Owner person = (Owner) Obj;
		try {
			TDG Another = new PersonTDG();
			Another.insert(Obj);
			ps.setString(1, person.getEmailAddress());
			ps.setString(2, person.getpassword());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PreparedStatement FillUpdate(Object Obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		Owner person = (Owner) Obj;
		try {
			TDG Another = new PersonTDG();
			Another.update(Obj);
			ps.setString(1, person.getpassword());
			ps.setString(2, person.getEmailAddress());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

}
