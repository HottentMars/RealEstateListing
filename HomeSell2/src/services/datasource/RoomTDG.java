package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.model.RealEstate.House;
import domain.model.RealEstate.RealEstate;
import domain.model.RealEstate.Room;

public class RoomTDG extends TDG{

	public RoomTDG()
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
		BASE_NAME = "Room";
	}

	@Override
	public void setInsert() {
		// TODO Auto-generated method stub
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (version, ree_id, room_type,size) " +
				"VALUES (?,?,?,?);";
	}

	@Override
	public void setUpdate() {
		// TODO Auto-generated method stub
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.version=p.version+1, p.room_type=?, p.size=? WHERE p.room_id=? AND p.version=?;";
	}

	@Override
	public void setDelete() {
		// TODO Auto-generated method stub
		DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.room_id=?;";
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
				+ TABLE + "As p Where p.room_id=?;";
	}

	@Override
	public Object getObject(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			List<Room> owners_room = new ArrayList<Room>();
			TDG tdg = new RealEstateTDG();
			
			while (rs.next()) {
				Room result = new Room(
						rs.getLong("room_id"),rs.getInt("version"),rs.getLong("ree_id"),rs.getString("room_type"),rs.getInt("size"));
				owners_room.add(result); 
			}
			return owners_room;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getAllObject(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			List<Room> owners_room = new ArrayList<Room>();
			TDG tdg = new RealEstateTDG();
			
			while (rs.next()) {
				Room result = new Room(
						rs.getLong("room_id"),rs.getInt("version"),rs.getLong("ree_id"),rs.getString("room_type"),rs.getInt("size"));
				owners_room.add(result); 
			}
			return owners_room;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PreparedStatement fillInsert(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		Room room = (Room) obj;
		try {
			ps.setLong(1,room.getVersion());
			ps.setLong(2,room.getRee_id());
			ps.setString(3, room.getRoom_type());
			ps.setInt(4, room.getSize());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public PreparedStatement fillUpdate(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		Room room = (Room) obj;
		try {
			ps.setString(1,room.getRoom_type());
			ps.setLong(2,room.getSize());
			ps.setLong(4, room.getRoom_id());
			ps.setInt(3, room.getVersion());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

}
