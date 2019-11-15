package per.czt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import per.czt.pojo.Article;
import per.czt.pojo.Comment;
import per.czt.pojo.Rely;
import per.czt.pojo.User;
import per.czt.service.CommentService;
import per.czt.service.RelyService;

@Controller
@RequestMapping("/rely")
public class RelyController {
	
	@Autowired
	private RelyService relyService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/showAll")
	public String searchAllComments(Model model) {
		List<Rely> relyList=relyService.searchAllRely();
		for(Rely rely:relyList) {
			
			/*System.out.println("rely_id:"+rely.getRely_id());
			System.out.println("rely_content:"+rely.getRely_content());
			System.out.println("rely_date:"+rely.getRely_date());
			System.out.println("rely_user:"+rely.getUser());
			System.out.println("rely_user_id:"+rely.getUser().getUser_id());
			System.out.println("rely_user_account:"+rely.getUser().getUser_account());
			System.out.println("rely_comment:"+rely.getComment());*/
			if(rely.getComment()!=null) {
				System.out.println("rely_comment_id:"+rely.getComment().getComment_id());
			}
			//System.out.println("rely_parent:"+rely.getParent_rely());
			if(rely.getParent_rely()!=null) {
				System.out.println("parent_rely_id:"+rely.getParent_rely().getRely_id());
			}
			//System.out.println("        rely.relies:"+rely.getRelies());
			for(Rely rely1:rely.getRelies()) {
				//System.out.println("        rely1_id:"+rely1.getRely_id());	
			}
		}
		model.addAttribute("relyList", relyList);
		return "relyList";
	}
	
    @RequestMapping("/insert/comment/{comment_id}")
	public String insertCommentRely(HttpServletRequest request,@PathVariable Integer comment_id,Rely rely) {
    	/*System.out.println("评论");
    	System.out.println("comment_id:"+comment_id);*/
		Comment comment=commentService.findCommentById(comment_id);
		//System.out.println("comment_id:"+comment.getComment_id());
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		rely.setUser(user);
		//System.out.println("user_id:"+user.getUser_id());
		rely.setRely_date(new java.util.Date());
		rely.setComment(comment);
		boolean result=relyService.insertCommentRely(rely);
		if(!result) {
			request.setAttribute("msg", "内部错误!");
			return "error";
		}
		//System.out.println("comment_article:"+comment.getArticle());
		return "redirect:/article/detail/"+comment.getArticle().getArticle_id();
	}
    
    @RequestMapping("/insert/rely/{rely_id}")
  	public String insertRelyRely(HttpServletRequest request,@PathVariable Integer rely_id,Rely rely) {
    	User user = (User) request.getSession().getAttribute("user");
  		if (user == null) {
  			request.setAttribute("msg", "您还未登录，请登录后再操作!");
  			return "error";
  		}
  		/*System.out.println("rely_id:"+rely_id);
  		System.out.println("rely_content:"+rely.getRely_content());*/
  		Rely parent_rely=relyService.findRelyById(rely_id);
  		rely.setParent_rely(parent_rely);
  		rely.setRely_date(new java.util.Date());
  		rely.setUser(user);
  		
 
  		boolean result=relyService.insertRelyRely(rely);
  		if(!result) {
  			request.setAttribute("msg", "内部错误!");
  			return "error";
  		}
  		/*System.out.println("rely_parent_rely:"+rely.getParent_rely());
  		System.out.println("rely_parent_rely_id:"+rely.getParent_rely().getRely_id());
  		
  		System.out.println("rely_parent_rely_comment:"+rely.getParent_rely().getComment());
  		System.out.println("rely_parent_rely_id_comment_id:"+rely.getParent_rely().getComment().getComment_id());
  		
  		
  		System.out.println("rely_parent_rely_comment_article:"+rely.getParent_rely().getComment().getArticle());
  		System.out.println("rely_parent_rely_id_comment_article_id:"+rely.getParent_rely().getComment().getArticle().getArticle_id());
  		*/
  		return "redirect:/article/detail/"+rely.getParent_rely().getComment().getArticle().getArticle_id();
  	}
	

}
