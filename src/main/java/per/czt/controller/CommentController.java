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
import per.czt.service.ArticleService;
import per.czt.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/showAll")
	public String searchAllComments(Model model) {
		List<Comment> commentList=commentService.searchAllComments();
		for(Comment comment:commentList) {
			/*System.out.println("comment_id0:"+comment.getComment_id0());
			System.out.println("comment_id:"+comment.getComment_id());
			
			System.out.println("comment_content:"+comment.getComment_content());
			System.out.println("comment_date:"+comment.getComment_date());
			System.out.println("comment_user:"+comment.getUser());
			System.out.println("comment_user_id:"+comment.getUser().getUser_id());
			System.out.println("comment_user_account:"+comment.getUser().getUser_account());
			System.out.println("comment_article:"+comment.getArticle());
			System.out.println("comment_article_id:"+comment.getArticle().getArticle_id());
			System.out.println("comment_article_content:"+comment.getArticle().getArticle_content());
			System.out.println("comment_relies:"+comment.getRelies());
			System.out.println("comment_relies_size:"+comment.getRelies().size());*/
			for(Rely rely:comment.getRelies()) {
				/*System.out.println("rely_id:"+rely.getRely_id());
				System.out.println("rely_content:"+rely.getRely_content());
				System.out.println("rely_date:"+rely.getRely_date());
				System.out.println("rely_user:"+rely.getUser());
				System.out.println("rely_user_id:"+rely.getUser().getUser_id());
				System.out.println("rely_user_account:"+rely.getUser().getUser_account());*/
				for(Rely rely1:rely.getRelies()) {
					//System.out.println("        rely1_id:"+rely1.getRely_id());
					
					
				}
			}
		}
		model.addAttribute("commentList", commentList);
		return "commentList";
	}
	@RequestMapping("/insert")
	public String insertComment(HttpServletRequest request,Comment comment,Integer article_id) {
		
		
		User user=(User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		
		comment.setUser(user);
		comment.setComment_date(new java.util.Date());
		//System.out.println("article:id:"+article_id);
		Article article=articleService.findArticleById(article_id);
		
		if(article==null) {
			request.setAttribute("msg", "评论失败!");
			return "error";
		}
		comment.setArticle(article);
		
		//System.out.println("article_id:"+article.getArticle_id());
	
		commentService.insertComment(comment);
		//System.out.println("插入成功!");
		
		return "redirect:/article/detail/"+article_id;
		
	}
	@RequestMapping("delete")
	public String deleteComment(HttpServletRequest request,Integer comment_id) {
		Comment comment=commentService.findCommentById(comment_id);
		comment.getArticle();
		Integer article_id= comment.getArticle().getArticle_id();
		boolean result=commentService.deleteCommentById(comment_id);
		if(!result) {
			request.setAttribute("msg", "该文章下有评论，不能删除!");
			return "error";
		}
		
		return "redirect:/article/detail/"+article_id;
	}
	

}
