package per.czt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import per.czt.mapper.UserMapper;
import per.czt.pojo.Article;
import per.czt.pojo.User;
import per.czt.pojo.UserAttention;
import per.czt.service.UserAttentionService;
import per.czt.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserAttentionService userAttentionService;
	
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	@RequestMapping("/showAll")
	public String showAllUsers(Model model) {
		List<User> userList=userService.searchAllUsers();
		model.addAttribute("userList",userList);
		//System.out.println("userList:"+userList);
		showUserList(userList,model);
		return "test/user_list3";
	}
	public void showUserList(List<User> userList,Model model){
		for(User u:userList) {
			/*System.out.println("user_id:"+u.getUser_id());
			System.out.println("user_account:"+u.getUser_account());
			System.out.println("user_password:"+u.getUser_password());*/
			
			System.out.println("user_profession:"+u.getProfession());
			if(u.getProfession()!=null) {
				//System.out.println("user_profession_id:"+u.getProfession().getProfession_id());
				
			}
			System.out.println("user_town:"+u.getTown());
			if(u.getTown()!=null) {
				/*System.out.println("user_town_id:"+u.getTown().getTown_id());
				System.out.println("user_city:"+u.getTown().getCity());*/
				if(u.getTown().getCity()!=null) {
					/*System.out.println("user_city_id:"+u.getTown().getCity().getCity_id());
					System.out.println("user_country:"+u.getTown().getCity().getCountry());*/
					if(u.getTown().getCity().getCountry()!=null) {
						//System.out.println("user_country_id:"+u.getTown().getCity().getCountry().getCountry_id());
					}
				}
				
			}
			
			
			
			
			
			
			
			
			
		}
		model.addAttribute("userList", userList);
	}
	@RequestMapping("/focus")
	public String focusUser(HttpServletRequest request,Integer user_id) {
		System.out.println("user_id:"+user_id);
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		UserAttention userAttention=new UserAttention();
		User focused_user=userService.findUserById(user_id);
		if(focused_user==null) {
			request.setAttribute("msg", "内部错误-1!");
			return "error";
		}
		userAttention.setFocus_user(user);
		userAttention.setFocused_user(focused_user);
		userAttention.setCreatedTime(new java.util.Date());
		boolean result=userAttentionService.insertUserAttention(userAttention);
		if(!result) {
			request.setAttribute("msg", "内部错误-2!");
			return "error";
		}
		
		
		return "redirect:/article/list?user_id="+focused_user.getUser_id();
		
	}
	
	@RequestMapping("/exitfocus")
	public String exitFocusUser(HttpServletRequest request,Integer user_attention_id) {
		
		System.out.println("user_attention_id:"+user_attention_id);
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		UserAttention userAttention=userAttentionService.searchUserAttentionById(user_attention_id);
		/*System.out.println("focused_user:"+userAttention.getFocused_user());
		System.out.println("focused_user_id:"+userAttention.getFocused_user().getUser_id());*/
		boolean result=userAttentionService.deleteUserAttentionById(user_attention_id);
		if(!result) {
			request.setAttribute("msg", "内部错误-2!");
			return "error";
		}
		return "redirect:/article/list?user_id="+userAttention.getFocused_user().getUser_id();
		
	}
	
	@RequestMapping("/town")
	public String showUsersByTownId(Integer town_id1,Integer town_id2,Model model) {
		List<User> userList=userService.selectUserByHomeTown(town_id1, town_id2);
		model.addAttribute("userList", userList);
		//System.out.println(userList.size());
		 showUserList(userList,model);
		
		return "test/user_list2";
		
	}
	
	@RequestMapping("/profession")
	public String showUserProfession(Model model) {
		List<User> userList=userService.selectUserProfession();
		model.addAttribute("userList", userList);
		//System.out.println(userList.size());
		 showUserList(userList,model);
		
		return "test/user_list";
		
	}
	
	@RequestMapping("/userArticleView")
	public String showUserArticleViews(Model model) {
		
		List userArticleViewsList=userService.getUserArticleViews();
		/*System.out.println("list:"+userArticleViewsList);
		System.out.println("list.size():"+userArticleViewsList.size());*/
		model.addAttribute("userArticleViewsList", userArticleViewsList);
		return "test/user_article_view";
	}
	
	
	
	

}
