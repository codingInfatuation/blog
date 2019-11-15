package per.czt.pojo;



public class UserArticleLikes {
	private Integer user_article_likes_id;
	private User user;
	private Article article;

	private java.util.Date createdTime;

	

	public Integer getUser_article_likes_id() {
		return user_article_likes_id;
	}

	public void setUser_article_likes_id(Integer user_article_likes_id) {
		this.user_article_likes_id = user_article_likes_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public UserArticleLikes() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
