package domain.model.mapper;

//import java.sql.Date;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import javax.servlet.http.HttpSession;
import services.datasource.TDG;

public class Mapper<T> {
	
	private static TDG ThatTDG;
	
	//The method "List<Object> findAll(String TheClassName)" returns a list of rows from the database where TheClassName argument defines the Table name.
	public  static List<Object> findAll(String TheClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//PersonIdentityMap.getInstance().clearIdentityMap();
		//PersonIdentityMap APersonMap= new PersonIdentityMap();
		
		ThatTDG = ReturnTDGInstance(TheClassName);
		List<Object> ListObject = ThatTDG.findAll();
		return ListObject;
	}
	
	//The method "Object find(Object ClassObject, String TheClassName)" returns a specific row from the database. ClassObject provides minimal information to search for that desired row in the database.  
	public static Object find(String ObjectId, String TheClassName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	//public static void find(Object ClassObject, String TheClassName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		// first check whether the person is in the identity map
		
		Object AnObject = null;//PersonIdentityMap.getInstance().get(id);
		ThatTDG = ReturnTDGInstance(TheClassName);
		if ( AnObject == null ){
			AnObject = ThatTDG.find(ObjectId);						
		}
		return AnObject;
	}

	public static void insert(Object ClassObject, String TheClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		System.out.printf("services.datasource."+TheClassName+"TDG"+"\n");
		ThatTDG = ReturnTDGInstance(TheClassName);
		ThatTDG.insert(ClassObject);		
	}
	
	public static void update(Object ClassObject, String TheClassName) throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		ThatTDG = ReturnTDGInstance(TheClassName);
		int count = ThatTDG.update(ClassObject);
		
		if(count == 0) {
		}	
	}
	
	public static void delete(String ObjectId, String TheClassName) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ThatTDG = ReturnTDGInstance(TheClassName);
		int count = ThatTDG.delete(ObjectId);
		if(count == 0) {
		}
	}
	
	public static TDG ReturnTDGInstance(String TheClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		return (TDG)Class.forName("services.datasource."+TheClassName+"TDG").newInstance();
	}
}
