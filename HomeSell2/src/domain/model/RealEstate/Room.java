package domain.model.RealEstate;

public class Room {
	private long room_id;
	private String ree_id;
	private String room_type;
	private int size;
	
	public Room(long room_id, String ree_id, String room_type, int size)
	{
		setRoom_id(room_id);
		setRee_id(ree_id);
		setRoom_type(room_type);
		setSize(size);
	}
	
	public long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}
	public String getRee_id() {
		return ree_id;
	}
	public void setRee_id(String ree_id) {
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
}
