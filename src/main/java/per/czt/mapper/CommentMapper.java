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

import per.czt.pojo.Comment;

public interface CommentMapper {
	@Insert("insert into comment(comment_content,user_id,article_id,comment_date) values(#{comment_content},#{user.user_id},#{article.article_id},#{comment_date})")
	public void insertComment(Comment comment);
	
	@Select("select comment_id as comment_id0,comment_id,comment_content,user_id,article_id,comment_date  from comment")
	@Results({
		@Result(column="article_id",property="article",one=@One(select="per.czt.mapper.ArticleMapper.findArticleById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		@Result(column="comment_id0",property="relies",many=@Many(select="per.czt.mapper.RelyMapper.findReliesByCommentId"))
		
	})
	public List<Comment> searchAllComments();
	
	@Select("select comment_id as comment_id0,comment_id,comment_content,user_id,article_id,comment_date from comment where article_id=#{article_id}")
	@Results({
		@Result(column="article_id",property="article",one=@One(select="per.czt.mapper.ArticleMapper.findArticleById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		@Result(column="comment_id0",property="relies",many=@Many(select="per.czt.mapper.RelyMapper.findReliesByCommentId"))
	})
	public List<Comment> findCommentsByArticleId(Integer article_id);
	
	@Select("select comment_id as comment_id0,comment_id,comment_content,user_id,article_id,comment_date from comment where comment_id=#{comment_id0} limit 1")
	@Results({
		@Result(column="article_id",property="article",one=@One(select="per.czt.mapper.ArticleMapper.findArticleById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		
	})
	public Comment findCommentById(Integer comment_id0);
	
	@Delete("delete from comment where article_id=#{article_id}")
	public void deleteCommentByArticleId(@Param("article_id")Integer article_id);
	
	@Delete("delete from comment where comment_id=#{comment_id}")
	public void deleteCommentById(@Param("comment_id")Integer comment_id);
	
	
	
	
	
	

}
