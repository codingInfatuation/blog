package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.CityMapper;
import per.czt.service.CityService;
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;
}
