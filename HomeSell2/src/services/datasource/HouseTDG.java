package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.model.RealEstate.House;
import domain.model.RealEstate.RealEstate;

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
				+ TABLE + "As p Where p.house_id=?;";
	}

	@Override
	public Object getObject(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if (rs.next()) {
//				House result = new House(
//						rs.getLong("p.id"),
//						rs.getInt("p.version"),
//						rs.getString("p.email_address"),
//						rs.getInt("p.civic_number"),
//						rs.getString("p.street"),
//						rs.getString("p.city"),
//						rs.getString("p.province"),
//						rs.getString("p.postal_code"),
//						rs.getDate("p.date_of_construction"),
//						rs.getInt("p.total_area"));
//				return result;
			}
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
