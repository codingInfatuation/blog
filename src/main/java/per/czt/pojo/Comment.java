package per.czt.pojo;

import java.util.List;

public class Comment {
	private Integer comment_id0;
	private Integer comment_id;
	private String comment_content;
	private User user;
	private Integer article_id;
	private Article article;
	private java.util.Date comment_date;
	private List<Rely> relies;
	
	public Integer getComment_id0() {
		return comment_id0;
	}
	public void setComment_id0(Integer comment_id0) {
		this.comment_id0 = comment_id0;
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public java.util.Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(java.util.Date comment_date) {
		this.comment_date = comment_date;
	}
	public List<Rely> getRelies() {
		return relies;
	}
	public void setRelies(List<Rely> relies) {
		this.relies = relies;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
