package per.czt.pojo;

public class City {
	private Integer city_id;
	private String city_name;
	/*private Integer country_id;*/
	private Country country;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public City(Integer city_id, String city_name, Country country) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.country = country;
	}
	
}
