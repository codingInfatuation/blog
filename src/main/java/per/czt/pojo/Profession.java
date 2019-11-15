package per.czt.pojo;

import java.util.List;

public class Profession {
	private Integer profession_id;
	private String profession_name;
	private List<User> users;
	public Integer getProfession_id() {
		return profession_id;
	}
	public void setProfession_id(Integer profession_id) {
		this.profession_id = profession_id;
	}
	public String getProfession_name() {
		return profession_name;
	}
	public void setProfession_name(String profession_name) {
		this.profession_name = profession_name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Profession(Integer profession_id, String profession_name, List<User> users) {
		super();
		this.profession_id = profession_id;
		this.profession_name = profession_name;
		this.users = users;
	}
	public Profession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
