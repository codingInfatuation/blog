package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.ProfessionMapper;
import per.czt.pojo.Profession;
import per.czt.service.ProfessionService;
@Service
public class ProfessionServiceImpl implements ProfessionService {
	@Autowired
	private ProfessionMapper professionMapper;

	@Override
	public List<Profession> searchAllProfessions() {
		// TODO Auto-generated method stub
		return professionMapper.searchAllProfessions();
	}
	
}
