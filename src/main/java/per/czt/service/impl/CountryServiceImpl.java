package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.CountryMapper;
import per.czt.service.CountryService;
@Service
public class CountryServiceImpl  implements CountryService{
	@Autowired
	private CountryMapper countryMapper;

}
