package per.czt.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import per.czt.pojo.Article;
import per.czt.pojo.ArticleCategory;
import per.czt.pojo.ArticleSort;
import per.czt.pojo.Category;
import per.czt.pojo.Comment;
import per.czt.pojo.Rely;
import per.czt.pojo.User;
import per.czt.pojo.UserArticleLikes;
import per.czt.pojo.UserAttention;
import per.czt.pojo.UserCategory;
import per.czt.service.ArticleCategoryService;
import per.czt.service.ArticleLabelService;
import per.czt.service.ArticleService;
import per.czt.service.ArticleSortService;
import per.czt.service.CommentService;
import per.czt.service.UserArticleLikesService;
import per.czt.service.UserCategoryService;
import per.czt.service.UserService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserArticleLikesService userArticleLikesService;
	@Autowired
	private UserService userService;

	@Autowired
	private ArticleSortService articleSortService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserCategoryService userCategoryService;
	@Autowired
	private ArticleCategoryService articleCategoryService;
	@Autowired
	private ArticleLabelService articleLabelSerice;
	@RequestMapping(value = "/list")
	public String listArticle(HttpServletRequest request, Model model) {

		// List<Article>
		// articleList=articleService.findArticlesByUserId(user.getUser_id());
		int user_id = 0;
		String str_user_id = request.getParameter("user_id");
		//System.out.println("str_user_id:" + str_user_id);
		if (str_user_id == null) {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
			} else {
				user_id = user.getUser_id();
			}
		} else {
			user_id = Integer.parseInt(str_user_id);
		}
		getUserLikesArticleCounts(user_id, model);
		int page = 1;
		int pageSize = 3;
		String strPageNow = request.getParameter("page");
		if (strPageNow != null) {
			page = Integer.parseInt(strPageNow);
		}
		int pageCount = articleService.getUserArticleRowCount(user_id, pageSize);
		/*System.out.println("pageNow:" + page);
		System.out.println("pageSize:" + pageSize);
		System.out.println("pageCount:" + pageCount);*/
		List<Article> articleList = articleService.searchUserArticlesByPage(user_id, (page - 1) * pageSize, pageSize);
		//System.out.println("articleList.size():" + articleList.size());
		for (Article article : articleList) {
			/*System.out.println("article_id0:" + article.getArticle_id0());

			System.out.println("article_id:" + article.getArticle_id());
			System.out.println("article_sort:" + article.getArticle_sort());*/
			if (article.getArticle_sort() != null) {
				/*System.out.println("article_sort_id:" + article.getArticle_sort().getArticle_sort_id());
				System.out.println("article_sort_name:" + article.getArticle_sort().getArticle_sort_name());*/

			} else {
				/*
				 * article.getArticle_sort().setArticle_sort_id(0);
				 * article.getArticle_sort().setArticle_sort_name("");
				 */
				article.setArticle_sort(null);
			}
			
			/*System.out.println("article_title:" + article.getArticle_title());
			System.out.println("article_content:" + article.getArticle_content());
			System.out.println("article_user:" + article.getUser());
			System.out.println("article_user_id:" + article.getUser().getUser_id());
			System.out.println("article_user_account:" + article.getUser().getUser_account());
			System.out.println("article_comments_count:" + article.getComments());*/
			for (Comment comment : article.getComments()) {
				/*System.out.println("comment_id:" + comment.getComment_id());
				 * System.out.println("comment_content:" + comment.getComment_content());
				 * System.out.println("comment_date:" + comment.getComment_date());
				 * System.out.println("comment_user:" + comment.getUser());
				 * System.out.println("comment_user_id:" + comment.getUser().getUser_id());
				 * System.out.println("comment_user_account:" +
				 * comment.getUser().getUser_account()); System.out.println("comment_article:" +
				 * comment.getArticle()); System.out.println("comment_article_id:" +
				 * comment.getArticle().getArticle_id());
				 * System.out.println("comment_article_content:" +
				 * comment.getArticle().getArticle_content());
				 */

			}
			//System.out.println("user_article_likes:" + article.getUserLikes());
			if (article.getUserLikes() != null) {
				//System.out.println("user_article_likes_size:" + article.getUserLikes().size());
			}
			for (UserArticleLikes userArticleLikes : article.getUserLikes()) {
				/*System.out.println("userArticleLikes_id:" + userArticleLikes.getUser_article_likes_id());
				System.out.println("userArticleLikes_user:" + userArticleLikes.getUser());
				System.out.println("userArticleLikes_user_id:" + userArticleLikes.getUser().getUser_id());*/

			}

		}
		User u1 = userService.findUserById(user_id);

		/*System.out.println("user_focus:" + u1.getUser_focus());
		System.out.println("user_focus_size:" + u1.getUser_focus().size());*/
		for (UserAttention userAttention : u1.getUser_focus()) {
			//System.out.println("user_attention_id:" + userAttention.getUser_attention_id());
			/*
			 * System.out.println("user_focus:"+userAttention.getFocus_user());
			 * System.out.println("user_focus_id:"+userAttention.getFocus_user().getUser_id(
			 * ));
			 
			System.out.println("user_focused:" + userAttention.getFocused_user());
			System.out.println("user_focused_id:" + userAttention.getFocused_user().getUser_id());*/
		}
		/*System.out.println("user_focused:" + u1.getUser_focused());
		System.out.println("user_focused_size:" + u1.getUser_focused().size());*/
		for (UserAttention userAttention : u1.getUser_focused()) {
			/*System.out.println("user_attention_id:" + userAttention.getUser_attention_id());
			System.out.println("user_focus:" + userAttention.getFocus_user());
			System.out.println("user_focus_id:" + userAttention.getFocus_user().getUser_id());*/
			/*
			 * System.out.println("user_focused:"+userAttention.getFocused_user());
			 * System.out.println("user_focused_id:"+userAttention.getFocused_user().
			 * getUser_id());
			 */

		}
		/*System.out.println("user_articlesWrited:" + u1.getArticlesWrited());
		System.out.println("user_articlesWrited_size:" + u1.getArticlesWrited().size());*/
		for (Article article : u1.getArticlesWrited()) {
			/*System.out.println("article_id:" + article.getArticle_id());
			System.out.println("article_user:" + article.getUser());
			System.out.println("article_user_id:" + article.getUser().getUser_id());*/

			/*
			 * System.out.println("article_sort:"+article.getArticle_sort());
			 * System.out.println("article_sort_id:"+article.getArticle_sort().
			 * getArticle_sort_id());
			 */

		}
		this.sortArticleByMonth(model, user_id);
		model.addAttribute("user", u1);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", page);
		model.addAttribute("user_id", user_id);
		model.addAttribute("articleList", articleList);
		return "article_list";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String goInsertArticle(HttpServletRequest request, Article article, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		List<ArticleSort> articleSortList = articleSortService.findAllArticleSorts();
		model.addAttribute("articleSortList", articleSortList);
		return "article_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String insertArticle(HttpServletRequest request, Article article, MultipartFile fileName,
			int article_sort_id,String []label,String []category) throws IllegalStateException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		/*System.out.println("article_title:" + article.getArticle_title());
		System.out.println("article_content:" + article.getArticle_content());
		System.out.println("category:"+category.length);*/
		
		for(String cate:category) {
			//System.out.println("category:"+cate);
			Category category0=new Category();
			category0.setCategory_name(cate); 
			
			UserCategory user_category=new UserCategory();
			user_category.setCategory(category0);
			user_category.setUser(user);
			user_category.setCreatedTime(new java.util.Date());
			
			
		}
		//System.out.println("label:"+label.length);
		for(String lab:label) {
			//System.out.println("label:"+lab);
		}
		java.util.Date now = new java.util.Date();

		article.setArticle_createdTime(now);
		article.setArticle_updatedTime(now);
		article.setArticle_views(0);
		article.setArticle_isPrivate(false);
		article.setArticle_top(0);
		
		fileName.transferTo(new File("C:\\blog\\static\\attachment\\"
				+ fileName.getOriginalFilename()));
		//System.out.println("fileName:" + fileName.getOriginalFilename());
		article.setArticle_attachment("\\attachment\\"+fileName.getOriginalFilename());
		//System.out.println("fileName:" + article.getArticle_attachment());
		article.setUser(user);
		//System.out.println(user.getUser_account());

		ArticleSort article_sort = articleSortService.findArticleSortById(article_sort_id);
		//System.out.println(article_sort.getArticle_sort_name());
		article.setArticle_sort(article_sort);
		try {
			articleService.insertArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/article/list";
	}

	@RequestMapping(value = "/edit/{article_id}", method = RequestMethod.GET)
	public String goEditArticle(HttpServletRequest request, @PathVariable("article_id") Integer article_id,
			Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}

		Article article = articleService.findArticleById(article_id);

		article.setArticle_content(HtmlUtils.htmlUnescape(article.getArticle_content()));
		article.setArticle_title(HtmlUtils.htmlUnescape(article.getArticle_title()));
		model.addAttribute("article", article);
		//System.out.println("article_id:" + article.getArticle_id());
		return "article_edit";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateArticle(HttpServletRequest request, Article article, MultipartFile fileName)
			throws IllegalStateException, IOException {
		Article article1 = articleService.findArticleById(article.getArticle_id());

		ArticleSort article_sort = articleSortService.findArticleSortById(2);
		article.setArticle_sort(article_sort);
		article.setArticle_updatedTime(new java.util.Date());
		article.setArticle_top(article1.getArticle_top());
		fileName.transferTo(new File("C:\\blog\\static\\attachment\\"
				+ fileName.getOriginalFilename()));
		//System.out.println("fileName:" + fileName.getOriginalFilename());
		article.setArticle_attachment("\\attachment\\"+fileName.getOriginalFilename());
		//System.out.println("fileName:" + article.getArticle_attachment());

		articleService.updateArticle(article);
		return "redirect:/article/list";

	}

	@RequestMapping(value = "/top/{article_id}", method = RequestMethod.GET)
	public String setTopArticle(@PathVariable("article_id") Integer article_id, Model model) {
		articleService.setTopNull();
		Article article = articleService.findArticleById(article_id);
		/*System.out.println("article_id:" + article.getArticle_id());
		System.out.println("article_top:" + article.getArticle_top());*/
		ArticleSort article_sort = articleSortService.findArticleSortById(2);
		article.setArticle_sort(article_sort);
		article.setArticle_updatedTime(new java.util.Date());
		article.setArticle_top(100);
		articleService.updateArticle(article);
		/*System.out.println("article_top:" + article.getArticle_top());

		System.out.println("article_id:" + article.getArticle_id());*/
		return "redirect:/article/list";
	}

	@RequestMapping(value = "/delete/{article_id}")
	public String deleteArticle(HttpServletRequest request, @PathVariable("article_id") Integer article_id) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}

		boolean result = articleService.deleteArticleById(article_id);
		if (!result) {
			request.setAttribute("msg", "该文章下有评论或被点赞，不能删除!");
			return "error";
		}
		return "redirect:/article/list";
	}

	@RequestMapping(value = "/delete2/{article_id}")
	public String deleteArticle2(HttpServletRequest request, @PathVariable("article_id") Integer article_id) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		commentService.deleteCommentByArticleId(article_id);
		boolean result = articleService.deleteArticleById(article_id);
		if (!result) {
			request.setAttribute("msg", "删除失败，异常错误!");
			return "error";
		}
		return "redirect:/article/list";
	}

	@RequestMapping(value = "/detail/{article_id}")
	public String viewDetailArticle(HttpServletRequest request, @PathVariable("article_id") Integer article_id,
			Model model) {

		Article article = articleService.findArticleById(article_id);
		/*System.out.println("article_id0:" + article.getArticle_id0());
		System.out.println("article_id:" + article.getArticle_id());

		System.out.println("article_id:" + article.getArticle_id());*/
		article.setArticle_attachment(article.getArticle_attachment());
		article.setArticle_content(HtmlUtils.htmlUnescape(article.getArticle_content()));
		article.setArticle_title(HtmlUtils.htmlUnescape(article.getArticle_title()));
		//System.out.println("article_comments:" + article.getComments());
		for (Comment comment : article.getComments()) {
			/*System.out.println("    comment_id:" + comment.getComment_id());
			System.out.println("    comment_user:" + comment.getUser());
			System.out.println("    comment_user_id:" + comment.getUser().getUser_id());
			System.out.println("comment_user_photo:" + comment.getUser().getUser_photo());
			System.out.println("    comment_article:" + comment.getArticle());
			System.out.println("    comment_article_id:" + comment.getArticle().getArticle_id());
			System.out.println("    comment_relies:" + comment.getRelies());*/
			for (Rely rely : comment.getRelies()) {
				/*System.out.println("        rely_id:" + rely.getRely_id());
				System.out.println("        rely_user:" + rely.getUser());
				System.out.println("        rely_user_id:" + rely.getUser().getUser_id());
				System.out.println("rely_user_photo:" + rely.getUser().getUser_photo());
				System.out.println("rely_user_photo:" + rely.getUser().getUser_photo());*/
				// getChildRelies(rely, 2);
				/*
				 * for(Rely rely1:rely.getRelies()) { rely1.setRely_id(rely1.getRely_id0());
				 * System.out.println("            rely1_id:"+rely1.getRely_id()); for(Rely
				 * rely2:rely1.getRelies()) { rely2.setRely_id(rely2.getRely_id0());
				 * System.out.println("               rely2_id:"+rely2.getRely_id());
				 * 
				 * } }
				 */
			}

		}
		model.addAttribute("article", article);

		return "article_detail";
		// return "comment";
	}

	public List<Rely> getChildRelies(Rely rely, int n) {
		System.out.println(rely.getRelies());
		for (Rely rely1 : rely.getRelies()) {
			for (int i = 0; i < n; i++) {
				System.out.print("    ");
			}
			/*System.out.println("        rely_id" + n + ":" + rely1.getRely_id());
			System.out.println("        rely_user" + n + ":" + rely1.getUser());
			System.out.println("        rely_user_id" + n + ":" + rely1.getUser().getUser_id());*/
			// this.getChildRelies(rely1, n + 1);
		}
		return rely.getRelies();
	}

	@RequestMapping("/agree")
	public String insertArticleLikes(HttpServletRequest request, Integer article_id,Integer user_id,Integer page) {
		//System.out.println("article_id:" + article_id);
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		UserArticleLikes userArticleLikes = new UserArticleLikes();

		userArticleLikes.setUser(user);
		userArticleLikes.setCreatedTime(new java.util.Date());
		Article article = articleService.findArticleById(article_id);
		if (article == null) {
			request.setAttribute("msg", "点赞失败!");
			return "error";
		}

		userArticleLikes.setArticle(article);
		boolean result = userArticleLikesService.insertUserArticleLikes(userArticleLikes);
		if (!result) {
			request.setAttribute("msg", "内部错误");
			return "error";
		} else {
			return "redirect:/article/list?page="+page+"&user_id="+user_id;
		}

	}

	@RequestMapping("/disagree")
	public String deleteArticleLikes(HttpServletRequest request, Integer user_article_likes_id,Integer user_id,Integer page) {
		//System.out.println("user_article_likes_id:" + user_article_likes_id);
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "您还未登录，请登录后再操作!");
			return "error";
		}
		boolean result = userArticleLikesService.deleteUserArticleLikesById(user_article_likes_id);

		if (!result) {
			request.setAttribute("msg", "内部错误");
			return "error";
		} else {
			return "redirect:/article/list?page="+page+"&user_id="+user_id;
		}

	}
	@RequestMapping("/archive")
	public String showArticleArchive(HttpServletRequest request,Integer user_id,String date,Model model) {
		
		/*System.out.println("user_id:"+user_id);
		System.out.println("date:"+date);*/
		int page = 1;
		int pageSize = 3;
		String strPageNow = request.getParameter("page");
		if (strPageNow != null) {
			page = Integer.parseInt(strPageNow);
		}
		int pageCount = articleService.getUserArticleRowCountByCreatedTime(user_id, date, pageSize);
		/*System.out.println("pageNow:" + page);
		System.out.println("pageSize:" + pageSize);
		System.out.println("pageCount:" + pageCount);*/
		List<Article> articleList=articleService.searchUserArticlesByCreatedTimeByPage(user_id, date, pageSize*(page-1), pageSize);
		showArticleList(articleList, user_id,model);
		model.addAttribute("date", date);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("page", page);
		model.addAttribute("user_id", user_id);
		model.addAttribute("articleList", articleList);
		
		return "article_archive";
		
	}
	public void showArticleList(List<Article> articleList,Integer user_id,Model model) {
		/*System.out.println("articleList:"+articleList);
		System.out.println("articleList.size():"+articleList.size());*/
		for (Article article : articleList) {
			/*System.out.println("article_id:" + article.getArticle_id());
			System.out.println("article_sort:" + article.getArticle_sort());*/
			if (article.getArticle_sort() != null) {
				/*System.out.println("article_sort_id:" + article.getArticle_sort().getArticle_sort_id());
				System.out.println("article_sort_name:" + article.getArticle_sort().getArticle_sort_name());*/

			} else {
				article.setArticle_sort(null);
			}
			article.setArticle_attachment(article.getArticle_attachment());
			/*System.out.println("article_title:" + article.getArticle_title());
			System.out.println("article_content:" + article.getArticle_content());
			System.out.println("article_user:" + article.getUser());
			System.out.println("article_user_id:" + article.getUser().getUser_id());
			System.out.println("article_user_account:" + article.getUser().getUser_account());
			System.out.println("article_comments_count:" + article.getComments());*/
			for (Comment comment : article.getComments()) {
				//System.out.println("comment_id:" + comment.getComment_id());


			}
			//System.out.println("user_article_likes:" + article.getUserLikes());
			if (article.getUserLikes() != null) {
				//System.out.println("user_article_likes_size:" + article.getUserLikes().size());
			}
			for (UserArticleLikes userArticleLikes : article.getUserLikes()) {
				/*System.out.println("userArticleLikes_id:" + userArticleLikes.getUser_article_likes_id());
				System.out.println("userArticleLikes_user:" + userArticleLikes.getUser());
				System.out.println("userArticleLikes_user_id:" + userArticleLikes.getUser().getUser_id());*/

			}

		}
		User u1 = userService.findUserById(user_id);

		/*System.out.println("user_focus:" + u1.getUser_focus());
		System.out.println("user_focus_size:" + u1.getUser_focus().size());*/
		for (UserAttention userAttention : u1.getUser_focus()) {
			/*System.out.println("user_attention_id:" + userAttention.getUser_attention_id());
			System.out.println("user_focused:" + userAttention.getFocused_user());
			System.out.println("user_focused_id:" + userAttention.getFocused_user().getUser_id());*/
		}
		/*System.out.println("user_focused:" + u1.getUser_focused());
		System.out.println("user_focused_size:" + u1.getUser_focused().size());*/
		for (UserAttention userAttention : u1.getUser_focused()) {
			/*System.out.println("user_attention_id:" + userAttention.getUser_attention_id());
			System.out.println("user_focus:" + userAttention.getFocus_user());
			System.out.println("user_focus_id:" + userAttention.getFocus_user().getUser_id());*/
		}
		/*System.out.println("user_articlesWrited:" + u1.getArticlesWrited());
		System.out.println("user_articlesWrited_size:" + u1.getArticlesWrited().size());*/
		for (Article article : u1.getArticlesWrited()) {
			/*System.out.println("article_id:" + article.getArticle_id());
			System.out.println("article_user:" + article.getUser());
			System.out.println("article_user_id:" + article.getUser().getUser_id());*/

		}
		this.sortArticleByMonth(model, user_id);

		model.addAttribute("user", u1);
		
	}
	
	
	
	public void sortArticleByMonth(Model model,Integer user_id) {
		List<Article> articleList2 = articleService.searchUserArticles(user_id);
		
		
		List<String> dateList = new ArrayList<String>();

		// 获取文章发表月份的数目
		for (Article article : articleList2) {
			// 定义要转换的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");

			// 将Date类型转换成String类型
			String format = sdf.format(article.getArticle_createdTime());

			// 打印format数据类型
			/*
			 * System.out.println(format.getClass().getName());
			 * System.out.println(format);//打印当前时间
			 */

			if (dateList.size() == 0) {
				dateList.add(format);
			} else {
				int i = 0;
				for (String str : dateList) {
					if (str.equals(format)) {
						i++;
						//System.out.println(str+":"+i);
					}
				}
				if (i == 0) {

					dateList.add(format);
				}
			}
		}
		List<Integer> countList = new ArrayList<>();
		List<String> dateList2 = new ArrayList<String>();
		for (String str : dateList) {
			//System.out.println("date:" + str);

			String str2 = str.substring(0, 4) + "-" + str.substring(5, 7);
			//System.out.println("date2:" + str2);
			dateList2.add(str2);
			Integer count=articleService.searchUserArticlesByCreatedTimeCounts(user_id, str2);
			//System.out.println(str2+":"+count);
			countList.add(count);
			
		}
		model.addAttribute("dateList2", dateList2);
		Map<String,Integer> dateMap=new HashMap<String,Integer>();
		for(int i=0;i<dateList2.size();i++) {
			dateMap.put(dateList2.get(i), countList.get(i));
		}
		model.addAttribute("dateMap", dateMap);
	}
	@RequestMapping("/labels")
	public String getLabels(String []label) {
		
		System.out.println("label1:" + label);
		for(String l:label) {
			//System.out.println("l:" + l);
			
		}
		
		return "";
		
	}
	public void getUserLikesArticleCounts(Integer user_id,Model model) {
		Integer articleCount=userArticleLikesService.getArticleLikesCounts(user_id);
		//model.addAttribute("userLikesArticle", articleCount);
		
		
	}
	
	
}
