package per.czt.pojo;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan

public class User {
	private Integer user_id;
	private Integer user_id1;
	/*private Integer profession_id;
	private Integer city_id;
	private Integer country_id;
	private Integer town_id;*/
	
	private Town town;
	private Profession profession;
	private String user_account;
	private String user_password;
	private String user_nickname;
	private String user_truename;
	private String user_sex;
	private String user_email;
	private String user_phoneNum;
	private String user_birthday;
	private String user_photo;
	private List<Article> articlesWrited;
	private List<Comment> comments;
	private List<Rely> relies;
	private List<UserArticleLikes> articleLikes;
	private List<UserAttention> user_focus;
	private List<UserAttention> user_focused;


	public Integer getUser_id1() {
		return user_id1;
	}


	public void setUser_id1(Integer user_id1) {
		this.user_id1 = user_id1;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public Town getTown() {
		return town;
	}


	public void setTown(Town town) {
		this.town = town;
	}


	public Profession getProfession() {
		return profession;
	}


	public void setProfession(Profession profession) {
		this.profession = profession;
	}


	public String getUser_account() {
		return user_account;
	}


	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_nickname() {
		return user_nickname;
	}


	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}


	public String getUser_truename() {
		return user_truename;
	}


	public void setUser_truename(String user_truename) {
		this.user_truename = user_truename;
	}


	public String getUser_sex() {
		return user_sex;
	}


	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_phoneNum() {
		return user_phoneNum;
	}


	public void setUser_phoneNum(String user_phoneNum) {
		this.user_phoneNum = user_phoneNum;
	}


	public String getUser_birthday() {
		return user_birthday;
	}


	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}


	public String getUser_photo() {
		return user_photo;
	}


	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}


	public List<Article> getArticlesWrited() {
		return articlesWrited;
	}


	public void setArticlesWrited(List<Article> articlesWrited) {
		this.articlesWrited = articlesWrited;
	}




	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public List<Rely> getRelies() {
		return relies;
	}


	public void setRelies(List<Rely> relies) {
		this.relies = relies;
	}


	public List<UserArticleLikes> getArticleLikes() {
		return articleLikes;
	}


	public void setArticleLikes(List<UserArticleLikes> articleLikes) {
		this.articleLikes = articleLikes;
	}


	public List<UserAttention> getUser_focus() {
		return user_focus;
	}


	public void setUser_focus(List<UserAttention> user_focus) {
		this.user_focus = user_focus;
	}


	public List<UserAttention> getUser_focused() {
		return user_focused;
	}


	public void setUser_focused(List<UserAttention> user_focused) {
		this.user_focused = user_focused;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
