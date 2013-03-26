package domain.model.RealEstate;

import java.sql.Date;

public class RealEstate {
	private Long realestate_id;
	private String owner_id;
	private int civic_number;
	private String street;
	private String city;
	private String province;
	private String postal_code;
	private Date dateOC; 
	private int total_area;
	private int version;
	
	public RealEstate(Long realestate_id, int version, String owner_id, int civic_number, String street, String city, 
			String province, String postal_code, Date dateOC, int total_area)
	{
		setVersion(version);
		setRealestate_id(realestate_id);
		setOwner_id(owner_id);
		setCivic_number(civic_number);
		setStreet(street);
		setCity(city);
		setProvince(province);
		setPostal_code(postal_code);
		setDateOC(dateOC);
	}
	public Long getRealestate_id() {
		return realestate_id;
	}
	public void setRealestate_id(Long realestate_id) {
		this.realestate_id = realestate_id;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public int getCivic_number() {
		return civic_number;
	}
	public void setCivic_number(int civic_number) {
		this.civic_number = civic_number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public Date getDateOC() {
		return dateOC;
	}
	public void setDateOC(Date dateOC) {
		this.dateOC = dateOC;
	}
	public int gettotal_area() {
		return total_area;
	}
	public void settotal_area(int total_area) {
		this.total_area = total_area;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

}
