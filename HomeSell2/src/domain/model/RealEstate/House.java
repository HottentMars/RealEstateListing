package domain.model.RealEstate;

import java.sql.Date;

public class House extends RealEstate{
	private int backyard_size;

	public House(String realestate_id, String owner_id, int civic_number, String street, String city, 
			String province, String postal_code, Date dateOC, int total_area, int backyard_size)
	{
		super(realestate_id, owner_id, civic_number, street, city, 
			province, postal_code, dateOC, total_area);
		
		setBackyard_size(backyard_size) ;
	}
	public int getBackyard_size() {
		return backyard_size;
	}

	public void setBackyard_size(int backyard_size) {
		this.backyard_size = backyard_size;
	}
	
}
