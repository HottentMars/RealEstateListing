package domain.model.RealEstate;

public class Picture {
	private Long pic_id;
	private int version;
	private Long ree_id;
	private String name;
	private String format; //jpeg, png, etc
	private String description;
	private int size; //in mb
	private int width;
	private int height;
	private String directory_location;
	
	public Picture(Long pic_id,int version, Long ree_id, String name, String format, String description, int size,
			int width, int height, String directory_location)
	{
		setPic_id(pic_id);
		setVersion(version);
		setRee_id(ree_id);
		setName(name);
		setFormat(format);
		setDescription(description);
		setSize(size);
		setWidth(width);
		setHeight(height);
		setDirectory_location(directory_location);
	}
	
	public Long getPic_id() {
		return pic_id;
	}
	public void setPic_id(Long pic_id) {
		this.pic_id = pic_id;
	}
	public Long getRee_id() {
		return ree_id;
	}
	public void setRee_id(Long ree_id) {
		this.ree_id = ree_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getDirectory_location() {
		return directory_location;
	}
	public void setDirectory_location(String directory_location) {
		this.directory_location = directory_location;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
