package per.czt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import per.czt.pojo.User;
import per.czt.pojo.UserArticleView;

public interface UserMapper {
	@Select("select user_id as user_id2,user_id as user_id0,user_id as user_id1,user_id,profession_id,town_id,town_id,user_account,user_password,user_nickname,user_truename,user_sex,user_email,user_phoneNum,user_photo,user_birthday from user")
	@Results({@Result(property="profession",column="profession_id",one=@One(select="per.czt.mapper.ProfessionMapper.findProfessionById")),
	@Result(property="town",column="town_id",one=@One(select="per.czt.mapper.TownMapper.findTownById")),
	@Result(property="articlesWrited",column="user_id0",many=@Many(select="per.czt.mapper.ArticleMapper.findArticlesByUserId")),
	@Result(property="user_focus",column="user_id1",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusId")),
	@Result(property="user_focused",column="user_id2",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusedId"))
	
	})
	public List<User> searchAllUsers();
	
	
	
	@Select("select * from user where profession_id=#{profession_id}")
	@Results({@Result(column="profession_id",property="profession",one=@One(select="per.czt.mapper.ProfessionMapper.findProfessionById"))})
	public List<User> findUserByProfessionId(Integer profession_id);
	
	@Select("select * from user where user_account=#{user_account} and user_password=#{user_password} limit 1")
	public User checkUser(User user);
	
	//嵌套查询
	@Select("select  user_id as user_id2,user_id as user_id0,user_id as user_id1,user_id,profession_id,town_id,town_id,user_account,user_password,user_nickname,user_truename,user_sex,user_email,user_phoneNum,user_photo,user_birthday from user where user_id in (select user_id from user where user_id=#{user_id})")
	@Results({@Result(property="profession",column="profession_id",one=@One(select="per.czt.mapper.ProfessionMapper.findProfessionById")),
		@Result(property="town",column="town_id",one=@One(select="per.czt.mapper.TownMapper.findTownById")),
		@Result(property="articlesWrited",column="user_id0",many=@Many(select="per.czt.mapper.ArticleMapper.findArticlesByUserId")),
		@Result(property="user_focus",column="user_id1",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusId")),
		@Result(property="user_focused",column="user_id2",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusedId"))
		
		})
	public User findUserById(Integer user_id);
	
	

	
	
	//视图
	@Select("select user_id,user_account,article_id,article_title,article_createdTime from user_article_view")
	public List<UserArticleView>  getUserArticleViews();
	
	
	//集合查询
	@Select("select * from user where town_id=#{town_id1} union select * from user where town_id=#{town_id2}")
	@Results({@Result(property="profession",column="profession_id",one=@One(select="per.czt.mapper.ProfessionMapper.findProfessionById")),
		@Result(property="town",column="town_id",one=@One(select="per.czt.mapper.TownMapper.findTownById")),
		@Result(property="articlesWrited",column="user_id0",many=@Many(select="per.czt.mapper.ArticleMapper.findArticlesByUserId")),
		@Result(property="user_focus",column="user_id1",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusId")),
		@Result(property="user_focused",column="user_id2",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusedId"))
		
		})
	public List<User> selectUserByHomeTown(@Param("town_id1")int town_id1,@Param("town_id2")int town_id2);
	
	
	//连接查询
	@Select("select user.user_id,user.user_account,user.profession_id from user left join profession on (user.profession_id =profession.profession_id);")
	@Results({@Result(property="profession",column="profession_id",one=@One(select="per.czt.mapper.ProfessionMapper.findProfessionById")),
		@Result(property="town",column="town_id",one=@One(select="per.czt.mapper.TownMapper.findTownById")),
		@Result(property="articlesWrited",column="user_id0",many=@Many(select="per.czt.mapper.ArticleMapper.findArticlesByUserId")),
		@Result(property="user_focus",column="user_id1",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusId")),
		@Result(property="user_focused",column="user_id2",many=@Many(select="per.czt.mapper.UserAttentionMapper.findUserAttentionByFocusedId"))
		
		})
	public List<User> selectUserProfession();
	
	
	
	
	
	
}
