package per.czt.service;

import java.util.List;



import per.czt.pojo.Article;

public interface ArticleService {
	public int getPageCount(int pageSize);
	public int getUserArticleRowCount(int pageSize,int user_id);
	public int getUserArticleRowCountByCreatedTime(int user_id,String article_createdTime,int pageSize);
	public List<Article> searchAllArticlesByPageOrderViews(int pageNow,int pageSize);
	public List<Article> searchAllArticlesByPageOrderTime(int pageNow,int pageSize);

	public List<Article> searchAllArticlesByPage(int pageNow,int pageSize);
	public List<Article> searchUserArticlesByPage(int user_id,int pageNow,int pageSize);
	public List<Article> searchUserArticles(int user_id);
	public List<Article> searchUserArticlesByCreatedTime(int user_id,String article_createdTime);
	public List<Article> searchUserArticlesByCreatedTimeByPage(int user_id,String article_createdTime,int pageNow,int pageSize);
	public Integer searchUserArticlesByCreatedTimeCounts(int user_id,String article_createdTime);
	
	
	public Article findArticleById(Integer article_id);
	public List<Article> findArticlesByUserId(Integer user_id);

	public void insertArticle(Article article);

	public void updateArticle(Article article);


	public boolean deleteArticleById(Integer  article_id);
	public void setTopNull();

}
