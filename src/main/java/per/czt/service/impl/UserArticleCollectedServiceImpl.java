package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.UserArticleCollectedMapper;
import per.czt.service.UserArticleCollectedService;
@Service
public class UserArticleCollectedServiceImpl implements UserArticleCollectedService{
	@Autowired
	private UserArticleCollectedMapper userArticleCollectedMapper;

}
