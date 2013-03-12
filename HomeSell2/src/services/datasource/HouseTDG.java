package services.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseTDG {
	public static final String TABLE = "Listing";
	
	public static final String INSERT = "INSERT INTO " + TABLE + 
					" (version, listingId, address, ownerId, price, yearOfConstruction, lotSize," +
					" totalLivingArea, heating, cooling, garage, driveway, drivewayCars, siding," +
					" windowType, yard, garden, additionalNotes) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	public static final String UPDATE = "UPDATE " + TABLE + 
					" AS h set h.version=h.version+1, h.listingId=?, h.address=?, h.ownerId=?, h.price=?," +
					" h.yearOfConstruction=?, h.lotSize=?, h.totalLivingArea=?, h.heating=?, h.cooling=?," +
					" h.garage=?, h.driveway=?, h.drivewayCars=?, h.siding=?, h.windowType=?, h.yard=?," +
					" h.garden=?, h.additionalNotes=?" +
					"WHERE h.version=? AND h.listingId=?;";
	
	public static final String DELETE = "DELETE FROM " + TABLE + " AS h WHERE h.version=? AND h.listingId=?;";
	
	public static final String SELECT_ALL = "SELECT h.version, h.listingId, h.address, h.ownerId, h.price," +
					" h.yearOfConstruction, h.lotSize, h.totalLivingArea, h.heating, h.cooling," +
					" h.garage, h.driveway, h.drivewayCars, h.siding, h.windowType, h.yard," +
					" h.garden, h.additionalNotes FROM " + TABLE + " AS h;";
	
	public static final String SELECT = "SELECT h.version, h.listingId, h.address, h.ownerId, h.price," +
					" h.yearOfConstruction, h.lotSize, h.totalLivingArea, h.heating, h.cooling," +
					" h.garage, h.driveway, h.drivewayCars, h.siding, h.windowType, h.yard," +
					" h.garden, h.additionalNotes FROM " + TABLE + " AS h WHERE h.listingId=?;";
	
	public static ResultSet findAll() throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(SELECT_ALL);
		return ps.executeQuery();
	}
	
	public static ResultSet find(long listingId) throws SQLException {
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(SELECT);
		ps.setLong(1, listingId);
		return ps.executeQuery();
	}
	
	public static void insert(int version, long listingId, String address, int ownerId, int price, int yearOfConstruction,
			int lotSize, int totalLivingArea, String heating, boolean cooling, String garage, String driveway,
			int drivewayCars, String siding, String windowType, boolean yard, boolean garden, String notes) throws SQLException {
		
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(INSERT);
		
		ps.setInt(1, version);
		ps.setLong(2, listingId);
		ps.setString(3, address);
		ps.setInt(4, ownerId);
		ps.setInt(5, price);
		ps.setInt(6, yearOfConstruction);
		ps.setInt(7, lotSize);
		ps.setInt(8, totalLivingArea);
		ps.setString(9, heating);
		ps.setBoolean(10, cooling);
		ps.setString(11, garage);
		ps.setString(12, driveway);
		ps.setInt(13, drivewayCars);
		ps.setString(14, siding);
		ps.setString(15, windowType);
		ps.setBoolean(16, yard);
		ps.setBoolean(17, garden);
		ps.setString(18, notes);
		
		ps.executeUpdate();
		ps.close();
	}

	public static int update(int version, long listingId, String address, int ownerId, int price, int yearOfConstruction,
			int lotSize, int totalLivingArea, String heating, boolean cooling, String garage, String driveway,
			int drivewayCars, String siding, String windowType, boolean yard, boolean garden, String notes) throws SQLException {
		
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(UPDATE); 
		
		ps.setInt(1, version);
		ps.setLong(2, listingId);
		ps.setString(3, address);
		ps.setInt(4, ownerId);
		ps.setInt(5, price);
		ps.setInt(6, yearOfConstruction);
		ps.setInt(7, lotSize);
		ps.setInt(8, totalLivingArea);
		ps.setString(9, heating);
		ps.setBoolean(10, cooling);
		ps.setString(11, garage);
		ps.setString(12, driveway);
		ps.setInt(13, drivewayCars);
		ps.setString(14, siding);
		ps.setString(15, windowType);
		ps.setBoolean(16, yard);
		ps.setBoolean(17, garden);
		ps.setString(18, notes);
		
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

	public static int delete(int version, long listingId) throws SQLException {
		
		PreparedStatement ps = MySQLConnection.getInstance().getConnection().prepareStatement(DELETE); 
		
		ps.setInt(1, version);
		ps.setLong(2, listingId);
		
		int count = ps.executeUpdate();
		ps.close();
		return count;
	}

}
