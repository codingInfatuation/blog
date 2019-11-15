package per.czt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import per.czt.pojo.UserArticleLikes;
import per.czt.pojo.UserAttention;

public interface UserAttentionMapper {
	@Insert("insert into user_attention(focus_user_id,focused_user_id,createdTime) values(#{focus_user.user_id},#{focused_user.user_id},#{createdTime})")
	public void insertUserAttention(UserAttention userAttention);

	@Delete("delete from user_attention where user_attention_id=#{user_attention_id}")
	public void deleteUserAttentionById(Integer user_attention_id);

	@Select("select user_attention_id,focus_user_id,focused_user_id,createdTime  from user_attention where  user_attention_id=#{user_attention_id}")
	@Results({
			@Result(column = "focus_user_id", property = "focus_user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")),
			@Result(column = "focused_user_id", property = "focused_user", one = @One(select = "per.czt.mapper.UserMapper.findUserById"))

	})
	public UserAttention searchUserAttentionById(@Param("user_attention_id") int user_attention_id);

	@Select("select user_attention_id,focus_user_id,focused_user_id,createdTime from user_attention where focus_user_id=#{focus_user_id}")
	@Results({
			@Result(column = "focus_user_id", property = "focus_user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")),
			@Result(column = "focused_user_id", property = "focused_user", one = @One(select = "per.czt.mapper.UserMapper.findUserById"))

	})
	public List<UserAttention> findUserAttentionByFocusId(Integer focus_user_id);

	@Select("select * from user_attention where focused_user_id=#{focused_user_id}")
	@Results({
			@Result(column = "focus_user_id", property = "focus_user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")),
			@Result(column = "focused_user_id", property = "focused_user", one = @One(select = "per.czt.mapper.UserMapper.findUserById")) })

	public List<UserAttention> findUserAttentionByFocusedId(Integer focused_user_id);

}
