package per.czt.pojo;

public class ArticleSort {
	private Integer article_sort_id;
	private String article_sort_name;
	public Integer getArticle_sort_id() {
		return article_sort_id;
	}
	public void setArticle_sort_id(Integer article_sort_id) {
		this.article_sort_id = article_sort_id;
	}
	public String getArticle_sort_name() {
		return article_sort_name;
	}
	public void setArticle_sort_name(String article_sort_name) {
		this.article_sort_name = article_sort_name;
	}
	public ArticleSort(Integer article_sort_id, String article_sort_name) {
		super();
		this.article_sort_id = article_sort_id;
		this.article_sort_name = article_sort_name;
	}
	public ArticleSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
