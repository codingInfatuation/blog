package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.ArticleCategoryMapper;
import per.czt.pojo.ArticleCategory;
import per.czt.service.ArticleCategoryService;
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;

	@Override
	public boolean insertArticleCategory(ArticleCategory articleCategory) {
		try {
			
			articleCategoryMapper.insertArticleCategory(articleCategory);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
