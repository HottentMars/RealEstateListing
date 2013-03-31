package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.model.RealEstate.House;
import domain.model.RealEstate.RealEstate;


public class RealEstateTDG extends TDG{

	public RealEstateTDG()
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
		// TODO Auto-generated method stub
		BASE_NAME = "RealEstate";
	}

	@Override
	public void setInsert() {
		// TODO Auto-generated method stub
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (version, email_address, civic_number,street,city,province,postal_code,date_of_construction,total_area) " +
				"VALUES (?,?,?,?,?,?,?,?,?);";
	}

	@Override
	public void setUpdate() {
		// TODO Auto-generated method stub
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.version=p.version+1, p.civic_number=?, p.street=?, p.city=? WHERE p.ree_id=?;";
	}

	@Override
	public void setDelete() {
		// TODO Auto-generated method stub
		DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.ree_id=? AND p.version=?;";
	}

	@Override
	public void setSelectAll() {
		// TODO Auto-generated method stub
		SELECT_ALL = "SELECT * FROM "
				+ TABLE + ";";
	}

	@Override
	public void setSelect() {
		// TODO Auto-generated method stub
		SELECT="SELECT * FROM "
		+ TABLE + " As p Where p.ree_id=?;";
	}

	@Override
	public Object getObject(ResultSet rs) {
		// TODO Auto-generated method stub
		List<RealEstate> owners_house = new ArrayList<RealEstate>();
		try {
			
			while (rs.next()) {
				RealEstate result = new RealEstate(
						rs.getLong("p.ree_id"),
						rs.getInt("p.version"),
						rs.getString("p.email_address"),
						rs.getInt("p.civic_number"),
						rs.getString("p.street"),
						rs.getString("p.city"),
						rs.getString("p.province"),
						rs.getString("p.postal_code"),
						rs.getDate("p.date_of_construction"),
						rs.getInt("p.total_area"));
				owners_house.add(result);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return owners_house;
	}

	@Override
	public List getAllObject(ResultSet rs) {
		// TODO Auto-generated method stub
		List<Object> reeList = new ArrayList<Object>();
		try {
			while (rs.next()) {
				RealEstate result = (RealEstate) getObject(rs);
				reeList.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reeList;
	}

	@Override
	public PreparedStatement fillInsert(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		RealEstate ree = (RealEstate) obj;
		//ResultSet generatedKeys = null;
		try {
			ps.setInt(1,ree.getVersion());
			ps.setString(2, ree.getOwner_id());
			ps.setInt(3, ree.getCivic_number());
			ps.setString(4, ree.getStreet());
			ps.setString(5, ree.getCity());
			ps.setString(6, ree.getProvince());
			ps.setString(7, ree.getPostal_code());
			ps.setDate(8, ree.getDateOC());
			ps.setInt(9, ree.gettotal_area());
			//generatedKeys = ps.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//RealEstateIdentityMap.getInstance().put(1, ree);
		return ps;
	}

	@Override
	public PreparedStatement fillUpdate(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		RealEstate ree = (RealEstate) obj;
		try {
			
			ps.setInt(1, ree.getCivic_number());
			ps.setString(2, ree.getStreet());
			ps.setString(3, ree.getCity());
			ps.setLong(4,ree.getRealestate_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

}
