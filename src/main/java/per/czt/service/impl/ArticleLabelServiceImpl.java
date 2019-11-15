package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.ArticleLabelMapper;
import per.czt.service.ArticleLabelService;
@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {
	
	@Autowired
	private ArticleLabelMapper articleLabelMapper;


	@Override
	public boolean insertArticleLabel(per.czt.pojo.ArticleLabel articleLabel) {
		try {
			articleLabelMapper.insertArticleLabel(articleLabel);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	

}
