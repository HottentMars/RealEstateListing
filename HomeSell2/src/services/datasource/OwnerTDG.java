package services.datasource;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.model.person.*;

public class OwnerTDG extends TDG{
	
	public OwnerTDG()
	{
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
		BASE_NAME = "Owner";
	}

	@Override
	public void setInsert() {
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (version, email_address, password) VALUES (?,?,?);";
	}

	@Override
	public void setUpdate() {
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.version=p.version+1, p.password=? WHERE p.email_address=? AND p.version=?;";
	}

	@Override
	public void setDelete() {
		DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.email_address=? AND p.version=?;";
	}

	@Override
	public void setSelectAll() {
		SELECT_ALL = "SELECT p.version,p.email_address, p.password FROM "
				+ TABLE + " AS p;";
	}

	@Override
	public void setSelect() {
		SELECT = "SELECT p.version, p.email_address, p.password FROM "
				+ TABLE + " AS p WHERE p.email_address=?;";
	}


	@Override
	public Object getObject(ResultSet rs) {
		try {
			if(rs.next()){
				TDG tdg = new PersonTDG();
				Person person = (Person)tdg.find(rs.getString("p.email_address"));
				System.out.println("email: "+ rs.getString("p.email_address")+"\n");
				System.out.println("email: "+ rs.getInt("p.version")+"\n");
				Owner result = new Owner(
						person.getId(),
						person.getVersion(),
						rs.getString("p.email_address"),
						person.getFirstName(),
						person.getLastName(),
						person.getDOB(),
						person.getPhoneNumber(),
						rs.getInt("p.version"),
						rs.getString("p.password")
				);				
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object> getAllObject(ResultSet rs) {
		List<Object> people = new ArrayList<Object>();
		
		try {
			
			while(rs.next()){ 
				if(rs.previous());
				Owner result = (Owner)getObject(rs);				
				people.add(result);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

	@Override
	public PreparedStatement fillInsert(Object obj, PreparedStatement ps) {
		Owner owner = (Owner) obj;
		try {
			TDG tdg = new PersonTDG();
			tdg.insert(obj);
			ps.setInt(1, owner.getOwnerVersion() );
			ps.setString(2, owner.getEmailAddress());
			ps.setString(3, owner.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PreparedStatement fillUpdate(Object obj, PreparedStatement ps) {
		Owner owner = (Owner) obj;
		try {
			TDG tdg = new PersonTDG();
			tdg.update(obj);
			ps.setString(1, owner.getPassword());
			ps.setString(2, owner.getEmailAddress());
			ps.setInt(3,  owner.getOwnerVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

//	@Override
//	public PreparedStatement fillSelect(Object objectId, PreparedStatement ps) {
//		// TODO Auto-generated method stub
//
//		try {
//			ps.setString(1, (String)objectId);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ps;
//
//
//	}
//
//	@Override
//	public PreparedStatement fillDelete(Object objectId, PreparedStatement ps) {
//		// TODO Auto-generated method stub
//		try {
//			ps.setString(1, (String)objectId);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ps;
//
//	}

}
