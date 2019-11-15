package per.czt.pojo;

public class UserArticleView {
	private Integer user_id;
	private Integer article_id;
	private String user_account;
	private String article_title;
	private String article_createdTime;
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
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_createdTime() {
		return article_createdTime;
	}
	public void setArticle_createdTime(String article_createdTime) {
		this.article_createdTime = article_createdTime;
	}
	public UserArticleView() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
