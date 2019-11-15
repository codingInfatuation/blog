package per.czt.mapper;

import org.apache.ibatis.annotations.Select;

import per.czt.pojo.Country;

public interface CountryMapper {
	@Select("select * from country  where country_id=#{country_id}")
	public Country findCountryById(Integer country_id);
}
