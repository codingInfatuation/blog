package per.czt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import per.czt.pojo.ArticleSort;

public interface ArticleSortMapper {
	@Select("select * from article_sort where article_sort_id=#{article_sort_id}")
	public ArticleSort findArticleSortById(Integer article_sort_id);
	@Select("select * from article_sort")
	public List<ArticleSort> findAllArticleSorts();

}
