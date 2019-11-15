package per.czt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import per.czt.pojo.Comment;
import per.czt.pojo.Rely;

public interface RelyMapper {
	
	@Insert("insert into rely(rely_content,user_id,comment_id,rely_date) values(#{rely_content},#{user.user_id},#{comment.comment_id},#{rely_date})")
	public void insertCommentRely(Rely rely);
	
	@Insert("insert into rely(rely_content,user_id,rely_parent_id,rely_date) values(#{rely_content},#{user.user_id},#{parent_rely.rely_id},#{rely_date})")
	public void insertRelyRely(Rely rely);
	
	@Select("select rely_id as rely_id0,rely_id,rely_content,user_id,comment_id,rely_parent_id,rely_date from rely")
	@Results({
		@Result(column="rely_parent_id",property="parent_rely",one=@One(select="per.czt.mapper.RelyMapper.findRelyById")),
		
		@Result(column="comment_id",property="comment",one=@One(select="per.czt.mapper.CommentMapper.findCommentById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		@Result(column="rely_id0",property="relies",many=@Many(select="per.czt.mapper.RelyMapper.findReliesByRelyId"))
		
	})
	public List<Rely> searchAllRely();
	
	@Select("select rely_id as rely_id0,rely_id,rely_content,user_id,comment_id,rely_parent_id,rely_date from rely where comment_id=#{comment_id}")
	@Results({
		@Result(column="rely_parent_id",property="parent_rely",one=@One(select="per.czt.mapper.RelyMapper.findRelyById")),
		
		@Result(column="comment_id",property="comment",one=@One(select="per.czt.mapper.CommentMapper.findCommentById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		@Result(column="rely_id0",property="relies",many=@Many(select="per.czt.mapper.RelyMapper.findReliesByRelyId"))
		
	})
	public List<Rely> findReliesByCommentId(Integer comment_id);
	@Select("select rely_id as rely_id0,rely_id,rely_content,user_id,comment_id,rely_parent_id,rely_date from rely where rely_id=#{rely_id0}")
	@Results({
		@Result(column="rely_parent_id",property="parent_rely",one=@One(select="per.czt.mapper.RelyMapper.findRelyById")),
		
		@Result(column="comment_id",property="comment",one=@One(select="per.czt.mapper.CommentMapper.findCommentById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		@Result(column="rely_id0",property="relies",many=@Many(select="per.czt.mapper.RelyMapper.findReliesByRelyId"))
		
	})
	public Rely findRelyById(Integer rely_id0);
	@Select("select rely_id as rely_id0,rely_id,rely_content,user_id,comment_id,rely_parent_id,rely_date from rely where rely_parent_id=#{rely_id0}")
	@Results({
		@Result(column="rely_parent_id",property="parent_rely",one=@One(select="per.czt.mapper.RelyMapper.findRelyById")),
		
		@Result(column="comment_id",property="comment",one=@One(select="per.czt.mapper.CommentMapper.findCommentById")),
		@Result(column="user_id",property="user",one=@One(select="per.czt.mapper.UserMapper.findUserById")),
		@Result(column="rely_id0",property="relies",many=@Many(select="per.czt.mapper.RelyMapper.findReliesByRelyId"))
		
	})
	public List<Rely> findReliesByRelyId(Integer rely_id0);
}
