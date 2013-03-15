package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public abstract class TDG {
	protected String BASE_NAME = "";
	protected String TABLE = MySQLConnection.getInstance().getTablePrefix()
			+ BASE_NAME;
	protected String INSERT = "";
	protected String UPDATE = "";
	protected String DELETE = "";
	
	public static String SELECT_ALL = "";
	public static String SELECT = "";
	
	public abstract void SetBaseName();

	public abstract void SetInsert();

	public abstract void SetUpdate();

	public abstract void SetDelete();

	public abstract void SetSelectAll();

	public abstract void SetSelect();

	public abstract Object getObject(ResultSet rs);

	public abstract List<Object> getAllObject(ResultSet rs);

	public abstract PreparedStatement FillInsert(Object Obj,
			PreparedStatement ps);

	public abstract PreparedStatement FillUpdate(Object Obj,
			PreparedStatement ps);

	public void SetTable()
	{
	TABLE = MySQLConnection.getInstance().getTablePrefix() + BASE_NAME;
	}
	
	public PreparedStatement FillSelect(String ObjectId, PreparedStatement ps) {
		// TODO Auto-generated method stub
		//Person person = (Person) Obj;
		try {
			ps.setString(1, ObjectId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
	public PreparedStatement FillDelete(String ObjectId, PreparedStatement ps) {
		//Person person = (Person) Obj;
		try {
			ps.setString(1, ObjectId);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	public List<Object> findAll() throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection()
				.prepareStatement(SELECT_ALL);
		return getAllObject(ps.executeQuery());
	}

	public Object find(String ObjectId) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection()
				.prepareStatement(SELECT);
		ps = FillSelect(ObjectId, ps);
		return getObject(ps.executeQuery());
	}

	public void insert(Object Obj) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection()
				.prepareStatement(INSERT);
		ps = FillInsert(Obj, ps);
		ps.executeUpdate();
		ps.close();
	}

	public int update(Object Obj) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection()
				.prepareStatement(UPDATE);
		ps = FillUpdate(Obj, ps);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

	public int delete(String ObjectId) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection()
				.prepareStatement(DELETE);
		ps = FillDelete(ObjectId, ps);
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}
}