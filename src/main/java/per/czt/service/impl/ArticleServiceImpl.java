package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.ArticleMapper;
import per.czt.pojo.Article;
import per.czt.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;

	

	@Override
	public void insertArticle(Article article) {
		articleMapper.insertArticle(article);
		
	}

	@Override
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article);
		
	}

	@Override
	public boolean deleteArticleById(Integer  article_id) {
		// TODO Auto-generated method stub
		try {
			articleMapper.deleteArticleById(article_id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Article findArticleById(Integer article_id) {
		// TODO Auto-generated method stub
		return articleMapper.findArticleById(article_id);
	}

	@Override
	public void setTopNull() {
		articleMapper.setTopNull();
		
	}

	@Override
	public List<Article> findArticlesByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		return articleMapper.findArticlesByUserId(user_id);
	}

	@Override
	public List<Article> searchAllArticlesByPage(int pageNow,int pageSize) {
		// TODO Auto-generated method stub
		return articleMapper.searchAllArticlesByPage(pageNow, pageSize);
	}

	@Override
	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		int rowCount=articleMapper.getRowCount();
		int pageCount=1;
		if(rowCount%pageSize==0) {
			pageCount=rowCount/pageSize;
		}else {
			pageCount=(rowCount/pageSize)+1;
		}
		
		
		return pageCount;
	}

	@Override
	public List<Article> searchAllArticlesByPageOrderViews(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return articleMapper.searchAllArticlesByPageOrderViews(pageNow, pageSize);
	}

	@Override
	public List<Article> searchAllArticlesByPageOrderTime(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return articleMapper.searchAllArticlesByPageOrderTime(pageNow, pageSize);
	}

	@Override
	public List<Article> searchUserArticlesByPage(int user_id, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return articleMapper.searchUserArticlesByPage(user_id, pageNow, pageSize);
	}

	@Override
	public int getUserArticleRowCount(int user_id,int pageSize) {
		int rowCount=articleMapper.getUserArticleRowCount(user_id);
		int pageCount=1;
		if(rowCount%pageSize==0) {
			pageCount=rowCount/pageSize;
		}else {
			pageCount=(rowCount/pageSize)+1;
		}
		
		return  pageCount;
	}

	@Override
	public List<Article> searchUserArticles(int user_id) {
		// TODO Auto-generated method stub
		return articleMapper.searchUserArticles(user_id);
	}

	@Override
	public List<Article> searchUserArticlesByCreatedTime(int user_id, String article_createdTime) {
		// TODO Auto-generated method stub
		return articleMapper.searchUserArticlesByCreatedTime(user_id, article_createdTime);
	}

	@Override
	public Integer searchUserArticlesByCreatedTimeCounts(int user_id, String article_createdTime) {
		// TODO Auto-generated method stub
		return articleMapper.searchUserArticlesByCreatedTimeCounts(user_id, article_createdTime);
	}

	@Override
	public List<Article> searchUserArticlesByCreatedTimeByPage(int user_id, String article_createdTime, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		return articleMapper.searchUserArticlesByCreatedTimeByPage(user_id, article_createdTime, pageNow, pageSize);
	}

	@Override
	public int getUserArticleRowCountByCreatedTime(int user_id, String article_createdTime,int pageSize) {
		// TODO Auto-generated method stub
		
		int rowCount=articleMapper.getUserArticleRowCountByCreatedTime(user_id, article_createdTime);
		int pageCount=1;
		if(rowCount%pageSize==0) {
			pageCount=rowCount/pageSize;
		}else {
			pageCount=(rowCount/pageSize)+1;
		}
		
		return  pageCount;
	}

	
}
