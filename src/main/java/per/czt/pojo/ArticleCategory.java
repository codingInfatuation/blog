package per.czt.pojo;

import java.util.Date;

public class ArticleCategory {
	private Integer article_category_id;
	private UserCategory user_category;
	private  Article  article;
	private java.util.Date createdTime;
	public Integer getArticle_category_id() {
		return article_category_id;
	}
	public void setArticle_category_id(Integer article_category_id) {
		this.article_category_id = article_category_id;
	}
	
	public UserCategory getUser_category() {
		return user_category;
	}
	public void setUser_category(UserCategory user_category) {
		this.user_category = user_category;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	public ArticleCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
