package per.czt.pojo;


public class ArticleLabel {
	private Integer article_label_id;
	private Article  article;
	private Label label;
	private java.util.Date createdTime;
	public Integer getArticle_label_id() {
		return article_label_id;
	}
	public void setArticle_label_id(Integer article_label_id) {
		this.article_label_id = article_label_id;
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Label getLabel() {
		return label;
	}
	public void setLabel(Label label) {
		this.label = label;
	}
	public java.util.Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public ArticleLabel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
