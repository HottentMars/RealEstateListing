package domain.model;
import java.util.HashMap;
import java.util.Map;

public class ResidenceMap {
	private Map<Long, Long> owner_to_estate;// = new HashMap<Long, Long>();
	private Map<Long, Long> estate_to_owner;//	private 
	private static ResidenceMap instance;
	
	private ResidenceMap()
	{
		owner_to_estate = new HashMap<Long, Long>();
		estate_to_owner = new HashMap<Long, Long>();
	}
	
	public static ResidenceMap getInstance() 
	{
		if (instance == null)
			instance = new ResidenceMap();
			
		return instance;
	}
	
	public void fillMap(long owner_id, long ree_id)
	{
		
	}
}
