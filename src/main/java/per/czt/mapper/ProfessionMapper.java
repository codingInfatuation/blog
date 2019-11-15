package per.czt.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Many;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import per.czt.pojo.Profession;

public interface ProfessionMapper {
	@Select("select * from profession  where  profession_id=#{profession_id}")
	public Profession findProfessionById(Integer profession_id);
	@Select("select * from profession")
	@Results({@Result(column="profession_id",property="users",many=@Many(select="per.czt.mapper.UserMapper.findUserByProfessionId"))})
	public List<Profession> searchAllProfessions();

}
