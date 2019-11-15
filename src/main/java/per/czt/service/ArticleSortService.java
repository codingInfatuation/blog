package per.czt.service;

import java.util.List;

import per.czt.pojo.ArticleSort;

public interface ArticleSortService {
	public ArticleSort findArticleSortById(Integer article_sort_id);
	public List<ArticleSort> findAllArticleSorts();

}
