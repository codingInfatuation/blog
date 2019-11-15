package per.czt.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Article {
    private Integer article_id0;
	private Integer article_id;
	private Integer article_id1;
	private String article_sort_name;
	/*private Integer user_id;
	private Integer article_sort_id;*/
	private User user;
	private ArticleSort article_sort;
	
	private String article_title;
	private String article_content;
	private Integer article_views;
	private java.util.Date article_createdTime; 
	private java.util.Date article_updatedTime;
	private boolean article_isPrivate;
	private Integer article_top;
	private String article_attachment;
	private MultipartFile fileName;
	private List<Comment> comments;
	private List<UserArticleLikes> userLikes;
	private UserCategory user_category;

	public Integer getArticle_id0() {
		return article_id0;
	}
	public void setArticle_id0(Integer article_id0) {
		this.article_id0 = article_id0;
	}
	public Integer getArticle_id1() {
		return article_id1;
	}
	public void setArticle_id1(Integer article_id1) {
		this.article_id1 = article_id1;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArticleSort getArticle_sort() {
		return article_sort;
	}
	public void setArticle_sort(ArticleSort article_sort) {
		this.article_sort = article_sort;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public Integer getArticle_views() {
		return article_views;
	}
	public void setArticle_views(Integer article_views) {
		this.article_views = article_views;
	}
	public java.util.Date getArticle_createdTime() {
		return article_createdTime;
	}
	public void setArticle_createdTime(java.util.Date article_createdTime) {
		this.article_createdTime = article_createdTime;
	}
	public java.util.Date getArticle_updatedTime() {
		return article_updatedTime;
	}
	public void setArticle_updatedTime(java.util.Date article_updatedTime) {
		this.article_updatedTime = article_updatedTime;
	}
	public boolean isArticle_isPrivate() {
		return article_isPrivate;
	}
	public void setArticle_isPrivate(boolean article_isPrivate) {
		this.article_isPrivate = article_isPrivate;
	}
	
	
	
	public String getArticle_attachment() {
		return article_attachment;
	}
	public void setArticle_attachment(String article_attachment) {
		this.article_attachment = article_attachment;
	}
	public Integer getArticle_top() {
		return article_top;
	}
	public void setArticle_top(Integer article_top) {
		this.article_top = article_top;
	}
	
	public MultipartFile getFileName() {
		return fileName;
	}
	public void setFileName(MultipartFile fileName) {
		this.fileName = fileName;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getArticle_sort_name() {
		return article_sort_name;
	}
	public void setArticle_sort_name(String article_sort_name) {
		this.article_sort_name = article_sort_name;
	}
	
	public List<UserArticleLikes> getUserLikes() {
		return userLikes;
	}
	public void setUserLikes(List<UserArticleLikes> userLikes) {
		this.userLikes = userLikes;
	}
	public UserCategory getUser_category() {
		return user_category;
	}
	public void setUser_category(UserCategory user_category) {
		this.user_category = user_category;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
