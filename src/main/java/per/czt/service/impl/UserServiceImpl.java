package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.czt.mapper.UserMapper;
import per.czt.pojo.User;
import per.czt.pojo.UserArticleView;
import per.czt.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> searchAllUsers() {
		return userMapper.searchAllUsers();
	}

	@Override
	public User findUserById(Integer user_id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(user_id);
	}

	@Override
	public User checkUser(User user) {
	
		return userMapper.checkUser(user);
	}

	@Override
	public List<UserArticleView> getUserArticleViews() {
		// TODO Auto-generated method stub
		return userMapper.getUserArticleViews();
	}
	

	@Override
	public List<User> selectUserByHomeTown(int town_id1, int town_id2) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByHomeTown(town_id1, town_id2);
	}

	@Override
	public List<User> selectUserProfession() {
		// TODO Auto-generated method stub
		return userMapper.selectUserProfession();
	}

}
