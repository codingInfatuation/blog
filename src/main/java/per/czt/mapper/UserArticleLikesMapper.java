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

import per.czt.pojo.UserArticleLikes;

public interface UserArticleLikesMapper {
	
	
	@Insert("insert into user_article_likes(user_id,article_id,created_time) values(#{user.user_id},#{article.article_id},#{createdTime})")
	public void insertUserArticleLikes(UserArticleLikes userArticleLikes);
	
	@Delete("delete from user_article_likes where user_article_likes_id=#{user_article_likes_id}")
	public void deleteUserArticleLikesById(Integer user_article_likes_id );
	
	
	@Select("select * from user_article_likes where  user_article_likes_id=#{user_article_likes_id}")
	public UserArticleLikes searchOneUserArticleLikes(@Param("user_article_likes_id")int user_article_likes_id);
	
	
	
    @Select("select * from user_article_likes where article_id=#{article_id1}")
    @Results({
    	@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
		
    })
	public List<UserArticleLikes> findArticleLikesByArticleId(Integer article_id1);
    
    @Select("select * from user_article_likes where user_id=#{user_id1}")
    @Results({
    	@Result(column = "user_id", property = "user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")), 
		
    })
    
	public List<UserArticleLikes> findArticleLikesByUserId(Integer user_id1);

	@Select("select count(*) from user_article_likes  where user_id=#{user_id}")
	public Integer getArticleLikesCounts(@Param("user_id")Integer user_id);
	

}
