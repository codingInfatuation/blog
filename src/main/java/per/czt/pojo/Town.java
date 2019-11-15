package per.czt.pojo;

public class Town {
	private Integer town_id;
	private String town_name;
	/*private Integer city_id;*/
	private City city;
	public Integer getTown_id() {
		return town_id;
	}
	public void setTown_id(Integer town_id) {
		this.town_id = town_id;
	}
	public String getTown_name() {
		return town_name;
	}
	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Town() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Town(Integer town_id, String town_name, City city) {
		super();
		this.town_id = town_id;
		this.town_name = town_name;
		this.city = city;
	}
	
}
