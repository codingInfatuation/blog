package per.czt.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import per.czt.pojo.City;

public interface CityMapper {
	@Select("select * from city where city_id=#{city_id}")
	@Results({@Result(column="country_id",property="country",one=@One(select="per.czt.mapper.CountryMapper.findCountryById"))})
	public City findCityById(Integer city_id);

}
