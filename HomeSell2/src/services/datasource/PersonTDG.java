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

	public PersonTDG() {
		setBaseName();
		setTable();
		setInsert();
		setUpdate();
		setDelete();
		setSelectAll();
		setSelect();
	}

	@Override
	public void setBaseName() {
		BASE_NAME = "Person";
	}

	@Override
	public void setInsert() {
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (version, email_address, first_name, last_name, date_of_birth, phone_number) VALUES (?,?,?,?,?,?);";
	}

	@Override
	public void setUpdate() {
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.version=p.version+1, p.email_address=?, p.first_name=?, p.last_name=?, p.date_of_birth=?, p.phone_number=? WHERE p.id=? AND p.version=?;";
	}

	@Override
	public void setDelete() {
		DELETE = "DELETE p FROM " + TABLE + " AS p WHERE p.id=? AND p.version=?;";
	}

	@Override
	public void setSelectAll() {
		SELECT_ALL = "SELECT p.id, p.version, p.email_address, p.first_name, p.last_name, p.date_of_birth, p.phone_number FROM "
				+ TABLE + " AS p;";
	}

	@Override
	public void setSelect() {
		SELECT = "SELECT p.id, p.version, p.email_address, p.first_name, p.last_name, p.date_of_birth, p.phone_number FROM "
				+ TABLE + " AS p WHERE p.email_address=?;";
	}

	@Override
	public PreparedStatement fillInsert(Object obj, PreparedStatement ps) {
		Person person = (Person) obj;
		try {
			//ps.setLong(1, person.getId());
			ps.setInt(1, person.getVersion());
			ps.setString(2, person.getEmailAddress());
			ps.setString(3, person.getFirstName());
			ps.setString(4, person.getLastName());
			ps.setDate(5, person.getDOB());
			ps.setLong(6, person.getPhoneNumber());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PreparedStatement fillUpdate(Object obj, PreparedStatement ps) {
		Person person = (Person) obj;
		try {
			ps.setString(1, person.getEmailAddress());
			ps.setString(2, person.getFirstName());
			ps.setString(3, person.getLastName());
			ps.setDate(4, person.getDOB());
			ps.setLong(5, person.getPhoneNumber());
			ps.setLong(6, person.getId());
			ps.setInt(7, person.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public Object getObject(ResultSet rs) {
		try {
			if (rs.next()) {
				Person result = new Person(
						rs.getLong("p.id"),
						rs.getInt("p.version"),
						rs.getString("p.email_address"),
						rs.getString("p.first_name"),
						rs.getString("p.last_name"),
						rs.getDate("p.date_of_birth"),
						rs.getLong("p.phone_number"));
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Object> getAllObject(ResultSet rs) {
		List<Object> people = new ArrayList<Object>();
		try {
			while (rs.next()) {
				Person result = (Person) getObject(rs);
				people.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

}
