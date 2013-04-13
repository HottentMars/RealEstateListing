package domain.model.RealEstate;

import java.sql.Date;

public class House extends RealEstate{
	private int backyard_size;

	public House(Long realestate_id, int version, String owner_id, int civic_number, String street, String city, 
			String province, String postal_code, Date dateOC, int total_area,String profile_pic, Long price, int backyard_size)
	{
		super(realestate_id, version, owner_id, civic_number, street, city, 
			province, postal_code, dateOC, total_area, profile_pic, price);
		
		setBackyard_size(backyard_size) ;
	}
	public int getBackyard_size() {
		return backyard_size;
	}

	public void setBackyard_size(int backyard_size) {
		this.backyard_size = backyard_size;
	}
	
}
