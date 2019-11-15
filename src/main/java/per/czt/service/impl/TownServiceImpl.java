package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.TownMapper;
import per.czt.service.TownService;
@Service
public class TownServiceImpl implements TownService{
	
	@Autowired
	private TownMapper townMapper;

}
