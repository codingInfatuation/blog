package per.czt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import per.czt.pojo.Article;
import per.czt.pojo.Comment;
import per.czt.pojo.UserArticleLikes;
import per.czt.service.ArticleService;
import per.czt.service.ArticleSortService;
import per.czt.service.UserService;


@Controller
public class PublicController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleSortService articleSortService;
	
	@RequestMapping("/{path}")
	public String showPage(@PathVariable String path) {
		return path;
	}
	@RequestMapping("/index")
	public String index(HttpServletRequest request,Model model) {
		int page=1;
		int pageSize=3;
		String strPageNow= request.getParameter("page");
		if(strPageNow!=null) {
			page=Integer.parseInt(strPageNow);
		}
		//System.out.println("pageNow:"+page);
		int pageCount=articleService.getPageCount(pageSize);
		/*System.out.println("pageNow:"+page);
		System.out.println("pageSize:"+pageSize);
		System.out.println("pageCount:"+pageCount);*/
		List<Article> articleList=articleService.searchAllArticlesByPage((page-1)*pageSize, pageSize);
		//System.out.println("articleList.size():"+articleList.size());
		for(Article article:articleList) {
			
			/*System.out.println("article_id:"+article.getArticle_id());
			System.out.println("article_sort:"+article.getArticle_sort());*/
			if(article.getArticle_sort()!=null) {
				/*System.out.println("article_sort_id:"+article.getArticle_sort().getArticle_sort_id());
				System.out.println("article_sort_name:"+article.getArticle_sort().getArticle_sort_name());*/
				
			}else {
				/*article.getArticle_sort().setArticle_sort_id(0);
				article.getArticle_sort().setArticle_sort_name("");*/
				article.setArticle_sort(null);
			}
			article.setArticle_content(HtmlUtils.htmlUnescape(article.getArticle_content()));
			article.setArticle_title(HtmlUtils.htmlUnescape(article.getArticle_title()));
			/*System.out.println("article_title:"+article.getArticle_title());
			System.out.println("article_content:"+article.getArticle_content());
			System.out.println("article_user:"+article.getUser());
			System.out.println("article_user_id:"+article.getUser().getUser_id());
			System.out.println("article_user_account:"+article.getUser().getUser_account());*/
			//System.out.println(article.getArticle_attachment());
			//article.setArticle_attachment(article.getArticle_attachment());
			/*System.out.println("article_attachment:"+article.getArticle_attachment());
			System.out.println("article_comments_count:" + article.getComments());*/
			for (Comment comment : article.getComments()) {
				//System.out.println("comment_id:" + comment.getComment_id());
				/*System.out.println("comment_content:" + comment.getComment_content());
				System.out.println("comment_date:" + comment.getComment_date());
				System.out.println("comment_user:" + comment.getUser());
				System.out.println("comment_user_id:" + comment.getUser().getUser_id());
				System.out.println("comment_user_account:" + comment.getUser().getUser_account());
				System.out.println("comment_article:" + comment.getArticle());
				System.out.println("comment_article_id:" + comment.getArticle().getArticle_id());
				System.out.println("comment_article_content:" + comment.getArticle().getArticle_content());*/

			}
			
			//System.out.println("user_article_likes:"+article.getUserLikes());
			if(article.getUserLikes()!=null) {
				//System.out.println("user_article_likes_size:"+article.getUserLikes().size());
			}
			for(UserArticleLikes userArticleLikes:article.getUserLikes()) {
				/*System.out.println("userArticleLikes_id:"+userArticleLikes.getUser_article_likes_id());
				System.out.println("userArticleLikes_user:"+userArticleLikes.getUser());
				System.out.println("userArticleLikes_user_id:"+userArticleLikes.getUser().getUser_id());*/
				
			}
			
		}
		List<Article> articleList2=articleService.searchAllArticlesByPageOrderTime(0, 8);
		List<Article> articleList3=articleService.searchAllArticlesByPageOrderViews(0, 5);
		//System.out.println("articleList3.size():"+articleList3.size());
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", page);
		model.addAttribute("articleList",articleList);
		model.addAttribute("articleList2",articleList2);
		model.addAttribute("articleList3",articleList3);
		return "index";
	}
	
	@RequestMapping("/test")
	public String showTest(Model model) {
	
		return "test/test";
	}
	
	

}
