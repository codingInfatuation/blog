package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.ArticleSortMapper;
import per.czt.pojo.ArticleSort;
import per.czt.service.ArticleSortService;
@Service
public class ArticleSortServiceImpl implements ArticleSortService{

	@Autowired
	private ArticleSortMapper articleSortMapper;

	@Override
	public ArticleSort findArticleSortById(Integer article_sort_id) {
		// TODO Auto-generated method stub
		return articleSortMapper.findArticleSortById(article_sort_id);
	}

	@Override
	public List<ArticleSort> findAllArticleSorts() {
		// TODO Auto-generated method stub
		return articleSortMapper.findAllArticleSorts();
	}
}
