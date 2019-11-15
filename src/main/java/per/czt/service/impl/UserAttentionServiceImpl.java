package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.UserAttentionMapper;
import per.czt.pojo.UserArticleLikes;
import per.czt.pojo.UserAttention;
import per.czt.service.UserAttentionService;
@Service 
public class UserAttentionServiceImpl implements UserAttentionService{

	@Autowired
	private UserAttentionMapper userAttentionMapper;

	@Override
	public boolean insertUserAttention(UserAttention userAttention) {
		// TODO Auto-generated method stub
		try {
			userAttentionMapper.insertUserAttention(userAttention);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean deleteUserAttentionById(Integer user_attention_id) {
		try {
			userAttentionMapper.deleteUserAttentionById(user_attention_id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserAttention searchUserAttentionById(int user_attention_id) {
		return userAttentionMapper.searchUserAttentionById(user_attention_id);
	
	}

	@Override
	public List<UserAttention> findUserAttentionByFocusId(Integer focus_user_id) {
		// TODO Auto-generated method stub
		return userAttentionMapper.findUserAttentionByFocusId(focus_user_id);
	}

	@Override
	public List<UserAttention> findUserAttentionByFocusedId(Integer focused_user_id) {
		// TODO Auto-generated method stub
		return userAttentionMapper.findUserAttentionByFocusedId(focused_user_id);
	}
	
}
