package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.model.RealEstate.House;
import domain.model.RealEstate.RealEstate;
import domain.model.person.Person;

public class HouseTDG extends TDG{

	public HouseTDG()
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
		BASE_NAME = "House";
	}

	@Override
	public void setInsert() {
		// TODO Auto-generated method stub
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (house_id,version, backyard_size) " +
				"VALUES (?,?,?);";
	}

	@Override
	public void setUpdate() {
		// TODO Auto-generated method stub
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.version=p.version+1, p.backyard_size=? WHERE p.house_id=? AND p.version=?;";
	}

	@Override
	public void setDelete() {
		// TODO Auto-generated method stub
		DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.house_id=? AND p.version=?;";
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
				+ TABLE + " As p Where  p.house_id=?;";
	}

	@Override
	public Object getObject(ResultSet rs) {
		// TODO Auto-generated method stub
		
		try {
			List<House> owners_house = new ArrayList<House>();
			TDG tdg = new RealEstateTDG();
			
			while (rs.next()) {
				List<RealEstate> realList = (List<RealEstate>)tdg.find(rs.getLong("p.house_id"));
				Iterator it = realList.iterator();
				RealEstate real = (RealEstate)it.next();
				House result = new House(
						rs.getLong("p.house_id"),
						rs.getInt("p.version"),
						real.getOwner_id(),
						real.getCivic_number(),
						real.getStreet(),
						real.getCity(),
						real.getProvince(),
						real.getPostal_code(),
						real.getDateOC(),
						real.gettotal_area(),
						real.getProfile_pic(),
						real.getPrice(),
						rs.getInt("p.backyard_size"));
				owners_house.add(result); 
			}
			return owners_house;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getAllObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement fillInsert(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		House house = (House) obj;
		try {
			ps.setLong(1,house.getRealestate_id());
			ps.setInt(2,house.getVersion());
			ps.setInt(3, house.getBackyard_size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PreparedStatement fillUpdate(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		House house = (House) obj;
		try {
			ps.setInt(1, house.getBackyard_size());
			ps.setLong(2,house.getRealestate_id());
			ps.setInt(3,house.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
}
