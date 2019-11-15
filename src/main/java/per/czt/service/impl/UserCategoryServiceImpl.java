package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.UserCategoryMapper;
import per.czt.pojo.UserCategory;
import per.czt.service.UserCategoryService;
@Service
public class UserCategoryServiceImpl implements UserCategoryService{

	@Autowired
	private UserCategoryMapper userCategoryMapper;

	@Override
	public boolean insertUserCategory(UserCategory userCategory) {
		// TODO Auto-generated method stub
		try {
			userCategoryMapper.insertUserCategory(userCategory);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
