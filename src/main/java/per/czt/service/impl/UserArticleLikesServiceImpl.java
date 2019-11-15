package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.UserArticleLikesMapper;
import per.czt.pojo.UserArticleLikes;
import per.czt.service.UserArticleLikesService;
@Service
public class UserArticleLikesServiceImpl implements UserArticleLikesService{
	@Autowired
	private UserArticleLikesMapper userArticleLikesMapper;

	@Override
	public boolean insertUserArticleLikes(UserArticleLikes userArticleLikes) {
		try {
			userArticleLikesMapper.insertUserArticleLikes(userArticleLikes);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}


	@Override
	public UserArticleLikes searchOneUserArticleLikes(int user_article_likes_id) {
		// TODO Auto-generated method stub
		return userArticleLikesMapper.searchOneUserArticleLikes(user_article_likes_id);
	}


	@Override
	public boolean deleteUserArticleLikesById(Integer user_article_likes_id) {
		// TODO Auto-generated method stub
		try {
			userArticleLikesMapper.deleteUserArticleLikesById(user_article_likes_id);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}


	@Override
	public Integer getArticleLikesCounts(Integer user_id) {
		// TODO Auto-generated method stub
		return userArticleLikesMapper.getArticleLikesCounts(user_id);
	}

}
