package per.czt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import per.czt.pojo.Article;

public interface ArticleMapper {
	
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article order by article_views desc limit #{pageNow},#{pageSize}")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId"))
	})

	public List<Article> searchAllArticlesByPageOrderViews(@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);
	
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article order by article_createdTime desc limit #{pageNow},#{pageSize}")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId"))
	})

	public List<Article> searchAllArticlesByPageOrderTime(@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);
	
	
	//select article_id from article where user_id in(select user_id from user where user.user_id=xx);
	//
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article order by article_top desc limit #{pageNow},#{pageSize}")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId")),
			@Result(column="article_id1",property="userLikes",many=@Many(select="per.czt.mapper.UserArticleLikesMapper.findArticleLikesByArticleId"))
	})
	public List<Article> searchAllArticlesByPage(@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);
	
	
	
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article where user_id=#{user_id} order by article_top desc limit #{pageNow},#{pageSize}")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId")),
			
			@Result(column="article_id1",property="userLikes",many=@Many(select="per.czt.mapper.UserArticleLikesMapper.findArticleLikesByArticleId"))
	})
	public List<Article> searchUserArticlesByPage(@Param("user_id")int user_id,@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);
	
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article where user_id=#{user_id} order by article_createdTime asc")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId")),
			
			@Result(column="article_id1",property="userLikes",many=@Many(select="per.czt.mapper.UserArticleLikesMapper.findArticleLikesByArticleId"))
	})
	public List<Article> searchUserArticles(@Param("user_id")int user_id);
	

	
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article where user_id=#{user_id} and date_format(article_createdTime,'%Y-%m') like #{article_createdTime} order by article_createdTime asc")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId")),
			
			@Result(column="article_id1",property="userLikes",many=@Many(select="per.czt.mapper.UserArticleLikesMapper.findArticleLikesByArticleId"))
	})
	
	public List<Article> searchUserArticlesByCreatedTime(@Param("user_id")int user_id,@Param("article_createdTime")String article_createdTime);
	
	@Select("select article_id as article_id0,article_id as article_id1,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article where user_id=#{user_id} and date_format(article_createdTime,'%Y-%m') like #{article_createdTime} order by article_createdTime asc limit #{pageNow},#{pageSize}")
	@Results({
			@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
			@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
			@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId")),
			
			@Result(column="article_id1",property="userLikes",many=@Many(select="per.czt.mapper.UserArticleLikesMapper.findArticleLikesByArticleId"))
	})
	
	public List<Article> searchUserArticlesByCreatedTimeByPage(@Param("user_id")int user_id,@Param("article_createdTime")String article_createdTime,@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);
	
	
	@Select("select count(*) from article where user_id=#{user_id} and date_format(article_createdTime,'%Y-%m') like #{article_createdTime} order by article_createdTime asc")
	public Integer searchUserArticlesByCreatedTimeCounts(@Param("user_id")int user_id,@Param("article_createdTime")String article_createdTime);
	
	
	
	@Select("select count(*) from article")
	public int getRowCount();
	
	@Select("select count(*) from article where user_id=#{user_id}")
	public int getUserArticleRowCount(@Param("user_id")int user_id);
	
	@Select("select count(*) from article where user_id=#{user_id} and date_format(article_createdTime,'%Y-%m') like #{article_createdTime}")
	public int getUserArticleRowCountByCreatedTime(@Param("user_id")int user_id,@Param("article_createdTime")String article_createdTime);
	
	
	@Select("select * from article where user_id=#{user_id} order by article_top desc")
	@Results({
		@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
		@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")),
		@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId"))
	})
	public List<Article> findArticlesByUserId(Integer user_id);
	

	
	
	
	@Select("select article_id as article_id0,article_id,user_id,article_sort_id,article_title,article_content,article_views,article_createdTime,article_updatedTime,article_isPrivate,article_top,article_attachment from article where article_id=#{article_id0}")
	@Results({
		@Result(column = "article_sort_id", property = "article_sort", one = @One(select = "per.czt.mapper.ArticleSortMapper.findArticleSortById")),
		@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")),
		@Result(column="article_id0",property="comments",many=@Many(select="per.czt.mapper.CommentMapper.findCommentsByArticleId"))
		})
	public Article findArticleById(Integer article_id0);
	
	
	
	@Insert("insert into article(article_title,article_content,article_sort_id,user_id,article_createdTime,article_updatedTime,article_views,article_isPrivate,article_top,article_attachment) values(#{article_title},#{article_content},#{article_sort.article_sort_id},#{user.user_id},#{article_createdTime},#{article_updatedTime},#{article_views},#{article_isPrivate},#{article_top},#{article_attachment})")
	public void insertArticle(Article article);
	
	@Update("update article set article_title=#{article_title},article_content=#{article_content},article_sort_id=#{article_sort.article_sort_id},article_updatedTime=#{article_updatedTime},article_isPrivate=#{article_isPrivate},article_top=#{article_top},article_attachment=#{article_attachment} where article_id=#{article_id}")
	public void updateArticle(Article article);
	
	@Delete("delete  from article  where article_id=#{article_id}")
	public void deleteArticleById(Integer  article_id);
	
	@Update("update article set article_top=0")
	public void setTopNull();
	
	
	
	
	
	
	
	
	
	
	
}
