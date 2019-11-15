package per.czt.service;

import java.util.List;

import per.czt.pojo.UserArticleLikes;
import per.czt.pojo.UserAttention;

public interface UserAttentionService {
	
    public boolean insertUserAttention(UserAttention userAttention);
	
	
	public boolean deleteUserAttentionById(Integer user_attention_id );
	
	
	
	public UserAttention searchUserAttentionById(int user_attention_id);
	
	
	
	public List<UserAttention> findUserAttentionByFocusId(Integer focus_user_id);
   
    
	public List<UserAttention> findUserAttentionByFocusedId(Integer focused_user_id);

}
