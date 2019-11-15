package per.czt.mapper;

import org.apache.ibatis.annotations.Select;

import per.czt.pojo.UserCategory;

public interface UserCategoryMapper {
	
	@Select("insert into user_category(user_id,category_id,created_time) values(#{user.user_id},#{category.category_id},#{created_time})")
	public void insertUserCategory(UserCategory userCategory);
	
	

}
