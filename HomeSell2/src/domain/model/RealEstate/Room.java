package domain.model.RealEstate;

public class Room {
	private Long room_id;
	private Long ree_id;
	private String room_type;
	private int size;
	private int version;
	
	public Room(Long room_id,int version, Long ree_id, String room_type, int size)
	{
		this.room_id=room_id;
		this.version=version;
		this.ree_id=ree_id;
		this.room_type=room_type;
		this.size=size;
	}
	
	public long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}
	public Long getRee_id() {
		return ree_id;
	}
	public void setRee_id(Long ree_id) {
		this.ree_id = ree_id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
