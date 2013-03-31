package domain.model.RealEstate;
import java.util.HashMap;
import java.util.Map;

public class Generatedkeymap {

	public static ThreadLocal<Generatedkeymap> identityMapInstance= new ThreadLocal<Generatedkeymap>();
	private Map<Integer, Long> KnownRealEstate;
	
	public Generatedkeymap() {
		KnownRealEstate = new HashMap<Integer, Long>(0);
	}
	
	public static Generatedkeymap getInstance() {
		//System.out.printf("I am thread#: "+Thread.currentThread().getId()+"\n");
		
		if (identityMapInstance.get() == null){
			identityMapInstance.set(new Generatedkeymap());
		}
		return identityMapInstance.get();
	}
	public void put(Integer id, Long restate){
		KnownRealEstate.put(id, restate);
	}
	
	public Long get(Integer id){
		Long restate = KnownRealEstate.get(id);
		return restate;
	}
	
	public void clearIdentityMap(){
		KnownRealEstate.clear();
	}
}
