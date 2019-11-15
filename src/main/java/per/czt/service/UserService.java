package per.czt.service;

import java.util.List;



import per.czt.pojo.User;
import per.czt.pojo.UserArticleView;

public interface UserService {
	public List<User> searchAllUsers();
	public User findUserById(Integer user_id);
	public User checkUser(User user);
	
	public List<UserArticleView>  getUserArticleViews();
	public List<User> selectUserByHomeTown(int town_id1,int town_id2);
	public List<User> selectUserProfession();


}
