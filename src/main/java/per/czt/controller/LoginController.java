package per.czt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import per.czt.pojo.Article;
import per.czt.pojo.User;
import per.czt.service.UserService;

@Controller

public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String goLogin(HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null) {
			/*System.out.println("user_id:"+user.getUser_id());
			System.out.println("user_account:"+user.getUser_account());
			System.out.println("user_password:"+user.getUser_password());*/
			return "redirect:/";
		}
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,User user,HttpServletResponse response) throws IOException {
		/*System.out.println("user_id:"+user.getUser_id());
		System.out.println("user_account:"+user.getUser_account());
		System.out.println("user_password:"+user.getUser_password());*/
		
        User user1=userService.checkUser(user);
        if(user1!=null) {
        	//System.out.println("登录成功!");
        	request.getSession().setAttribute("user", user1);
        	
        	return "redirect:/";
        }else {
        	//System.out.println("用户名或密码错误!");
        	
        	return "redirect:/login";
        }
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,User user) {
		request.getSession().removeAttribute("user");
        return "redirect:/";
        
	}
	
	

}
