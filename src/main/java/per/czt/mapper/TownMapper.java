package per.czt.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import per.czt.pojo.Town;

public interface TownMapper {
	@Select("select * from town where town_id=#{town_id}")
	@Results({@Result(column="city_id",property="city",one=@One(select="per.czt.mapper.CityMapper.findCityById"))})
	public Town findTownById(Integer town_id);

}
