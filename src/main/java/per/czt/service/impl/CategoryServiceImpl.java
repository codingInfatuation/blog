package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.CategoryMapper;
import per.czt.service.CategoryService;
@Service
public class CategoryServiceImpl  implements CategoryService{

	@Autowired
	private CategoryMapper categroyMapper;
}
