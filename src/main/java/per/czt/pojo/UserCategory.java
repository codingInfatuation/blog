package per.czt.pojo;



public class UserCategory {
	private Integer user_category_id;
	private User user;
	private Category category;
	private java.util.Date createdTime;
	public Integer getUser_category_id() {
		return user_category_id;
	}
	public void setUser_category_id(Integer user_category_id) {
		this.user_category_id = user_category_id;
	}

	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public UserCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
