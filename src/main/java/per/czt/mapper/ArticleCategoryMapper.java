package per.czt.mapper;

import org.apache.ibatis.annotations.Select;

import per.czt.pojo.ArticleCategory;
import per.czt.pojo.UserCategory;

public interface ArticleCategoryMapper {
	@Select("insert into article_category(article_id,user_category_id,created_time) values(#{article.article_id},#{user_category.user_category_id},#{created_time})")
	public void insertArticleCategory(ArticleCategory articleCategory);

}
