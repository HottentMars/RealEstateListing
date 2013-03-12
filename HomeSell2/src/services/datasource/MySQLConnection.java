package services.datasource;

import java.sql.*;


public class MySQLConnection {
	static private Connection conn = null;
	static private MySQLConnection instance = null;
	private String UserName = "";
    private String HostName= "";
    private String DatabaseName = "";
    private String TablePrefix = "";
    private String PassWord = "";
    //private int Port = 3306;
    
    private MySQLConnection()
    {
    	InitializeData();
    }
    
    public static MySQLConnection getInstance() {
    	if (instance == null){
			instance = new MySQLConnection();
		}
		return instance;
    }
    
    public void InitializeData()
    {
    	this.UserName = ConnectionData.getString("mySqlUserName");
    	this.HostName = ConnectionData.getString("mySqlHostName");
    	this.PassWord = ConnectionData.getString("mySqlPassword");
    	this.DatabaseName = ConnectionData.getString("mySqlDatabase");
    	this.TablePrefix = ConnectionData.getString("mySqlTablePrefix");
    	
    	SetConnection();
    }
    
    public Connection getConnection()
    {
    	return conn;
    }
    public String getDBURL() {
		return "jdbc:mysql://" + HostName + "/" + DatabaseName;
	}
    
    
    
    public String getTablePrefix()
    {
    	return TablePrefix;
    }
    
    public void SetConnection()
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			conn = DriverManager.getConnection(getDBURL(), UserName, PassWord);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
