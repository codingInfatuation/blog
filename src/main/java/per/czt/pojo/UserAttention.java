package per.czt.pojo;

import java.util.Date;

public class UserAttention {

	
	private Integer user_attention_id;
	private Integer focus_user_id;
	private Integer focused_user_id;
	private User focus_user;
	private User focused_user;
	private java.util.Date createdTime;
	public Integer getUser_attention_id() {
		return user_attention_id;
	}
	public void setUser_attention_id(Integer user_attention_id) {
		this.user_attention_id = user_attention_id;
	}
	public Integer getFocus_user_id() {
		return focus_user_id;
	}
	public void setFocus_user_id(Integer focus_user_id) {
		this.focus_user_id = focus_user_id;
	}
	public Integer getFocused_user_id() {
		return focused_user_id;
	}
	public void setFocused_user_id(Integer focused_user_id) {
		this.focused_user_id = focused_user_id;
	}
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	public UserAttention(Integer user_attention_id, Integer focus_user_id, Integer focused_user_id, Date createdTime) {
		super();
		this.user_attention_id = user_attention_id;
		this.focus_user_id = focus_user_id;
		this.focused_user_id = focused_user_id;
		this.createdTime = createdTime;
	}
	public UserAttention() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getFocus_user() {
		return focus_user;
	}
	public void setFocus_user(User focus_user) {
		this.focus_user = focus_user;
	}
	public User getFocused_user() {
		return focused_user;
	}
	public void setFocused_user(User focused_user) {
		this.focused_user = focused_user;
	}
	
}
