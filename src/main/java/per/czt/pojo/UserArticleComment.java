package per.czt.pojo;

import java.util.Date;

public class UserArticleComment {
	private Integer user_article_comment_id;
	private Integer user_id;
	private Integer article_id;
	private Integer comment_id;
	private java.util.Date createdTime;
	public Integer getUser_article_comment_id() {
		return user_article_comment_id;
	}
	public void setUser_article_comment_id(Integer user_article_comment_id) {
		this.user_article_comment_id = user_article_comment_id;
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
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	public UserArticleComment(Integer user_article_comment_id, Integer user_id, Integer article_id, Integer comment_id,
			Date createdTime) {
		super();
		this.user_article_comment_id = user_article_comment_id;
		this.user_id = user_id;
		this.article_id = article_id;
		this.comment_id = comment_id;
		this.createdTime = createdTime;
	}
	public UserArticleComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
