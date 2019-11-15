package per.czt.pojo;

import java.util.List;

public class Rely {
	private Integer rely_id0;
	private Integer rely_id;
	private String rely_content;
	private java.util.Date rely_date;
	private User user;
	private Comment comment;
	private Rely parent_rely;
	private List<Rely> relies;
	public Integer getRely_id0() {
		return rely_id0;
	}
	
	public void setRely_id0(Integer rely_id0) {
		this.rely_id0 = rely_id0;
	}
	public Integer getRely_id() {
		return rely_id;
	}
	public void setRely_id(Integer rely_id) {
		this.rely_id = rely_id;
	}
	public String getRely_content() {
		return rely_content;
	}
	public void setRely_content(String rely_content) {
		this.rely_content = rely_content;
	}
	
	public java.util.Date getRely_date() {
		return rely_date;
	}
	public void setRely_date(java.util.Date rely_date) {
		this.rely_date = rely_date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public Rely getParent_rely() {
		return parent_rely;
	}
	public void setParent_rely(Rely parent_rely) {
		this.parent_rely = parent_rely;
	}
	public List<Rely> getRelies() {
		return relies;
	}
	public void setRelies(List<Rely> relies) {
		this.relies = relies;
	}
	public Rely() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
