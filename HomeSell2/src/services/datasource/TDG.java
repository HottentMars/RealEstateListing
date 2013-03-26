package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import domain.model.RealEstate.Generatedkeymap;

public abstract class TDG<T> {
	protected String BASE_NAME = "";
	protected String TABLE = MySQLConnection.getInstance().getTablePrefix()	+ BASE_NAME;
	protected String INSERT = "";
	protected String UPDATE = "";
	protected String DELETE = "";

	public static String SELECT_ALL = "";
	public static String SELECT = "";

	public abstract void setBaseName();

	public abstract void setInsert();

	public abstract void setUpdate();

	public abstract void setDelete();

	public abstract void setSelectAll();

	public abstract void setSelect();

	public abstract Object getObject(ResultSet rs);

	public abstract List<Object> getAllObject(ResultSet rs);

	public abstract PreparedStatement fillInsert(Object obj, PreparedStatement ps);

	public abstract PreparedStatement fillUpdate(Object obj, PreparedStatement ps);

	public void setTable() {
		TABLE = MySQLConnection.getInstance().getTablePrefix() + BASE_NAME;
	}

	public PreparedStatement fillSelect(Object objectId, PreparedStatement ps) 
	{
		try {
			
			ps.setObject(1, objectId );
			//ps.set

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public PreparedStatement fillDelete(Object objectId, PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setObject(1, objectId);
			//ps.setObject(, objectId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;

	}
 

	public List<Object> findAll() throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(SELECT_ALL);
		return getAllObject(ps.executeQuery());
	}

	public Object find(T objectId) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(SELECT);
		ps = fillSelect(objectId, ps);
		return getObject(ps.executeQuery());
	}

	public void insert(Object obj) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
		ps = fillInsert(obj, ps);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next())
			Generatedkeymap.getInstance().put(1, (Long)rs.getLong(1));//getting generated keys
		ps.close();
	}

	public int update(Object obj) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(UPDATE);
		ps = fillUpdate(obj, ps);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

	public int delete(T objectId) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(DELETE);
		ps = fillDelete(objectId, ps);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}
}