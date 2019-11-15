package per.czt.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import per.czt.pojo.UserArticleView;
import per.czt.service.UserService;
import per.czt.service.impl.UserServiceImpl;

public class TestView {
	@Autowired
	private static UserService userService;
	public static void main(String []args) {
		
		
		List<UserArticleView>  userArticleViewsList=userService.getUserArticleViews();
		System.out.println("list:"+userArticleViewsList);
		System.out.println("list.size():"+userArticleViewsList.size());
		
	}

}
