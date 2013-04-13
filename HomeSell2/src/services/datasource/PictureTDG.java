package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.model.RealEstate.Picture;


public class PictureTDG extends TDG{

	public PictureTDG()
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
		BASE_NAME = "Picture";
	}

	@Override
	public void setInsert() {
		// TODO Auto-generated method stub
		INSERT = "INSERT INTO "
				+ TABLE
				+ " (version, ree_id, name, format, description, size, width, height, dir_location) " +
				"VALUES (?,?,?,?);";
	}

	@Override
	public void setUpdate() {
		// TODO Auto-generated method stub
		UPDATE = "UPDATE "
				+ TABLE
				+ " AS p set p.version=p.version+1, p.name=?, p.description=?, p.dir_location=? WHERE p.pic_id=? AND p.version=?;";
	}

	@Override
	public void setDelete() {
		// TODO Auto-generated method stub
		DELETE = "DELETE FROM " + TABLE + " AS p WHERE p.pic_id=?;";
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
				+ TABLE + "As p Where p.pic_id=?;";
	}

	@Override
	public Object getObject(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			List<Picture> Pic_List = new ArrayList<Picture>();
			//TDG tdg = new RealEstateTDG();
			
			while (rs.next()) {
				Picture result = new Picture(
						rs.getLong("pic_id"),
						rs.getInt("version"),
						rs.getLong("ree_id"),
						rs.getString("name"),
						rs.getString("format"),
						rs.getString("description"),
						rs.getInt("size"),
						rs.getInt("width"),
						rs.getInt("height"),
						rs.getString("dir_location"));
				Pic_List.add(result); 
			}
			return Pic_List;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object> getAllObject(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement fillInsert(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement fillUpdate(Object obj, PreparedStatement ps) {
		// TODO Auto-generated method stub
		return null;
	}

}
