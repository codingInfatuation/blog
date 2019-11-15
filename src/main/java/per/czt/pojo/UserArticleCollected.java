package per.czt.pojo;

import java.util.Date;

public class UserArticleCollected {
	private Integer user_article_collected;
	private Integer user_id;
	private Integer article_id;
	private java.util.Date createdTime;
	public Integer getUser_article_collected() {
		return user_article_collected;
	}
	public void setUser_article_collected(Integer user_article_collected) {
		this.user_article_collected = user_article_collected;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	public UserArticleCollected(Integer user_article_collected, Integer user_id, Integer article_id, Date createdTime) {
		super();
		this.user_article_collected = user_article_collected;
		this.user_id = user_id;
		this.article_id = article_id;
		this.createdTime = createdTime;
	}
	public UserArticleCollected() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
