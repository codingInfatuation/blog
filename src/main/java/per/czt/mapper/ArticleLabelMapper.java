package per.czt.mapper;

import org.apache.ibatis.annotations.Select;

import per.czt.pojo.ArticleCategory;
import per.czt.pojo.ArticleLabel;

public interface ArticleLabelMapper {
	@Select("insert into article_label(article_id,label_id,created_time) values(#{article.article_id},#{label.label_id},#{created_time})")
	public void insertArticleLabel(ArticleLabel articleLabel);

}
