package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.RelyMapper;
import per.czt.pojo.Comment;
import per.czt.pojo.Rely;
import per.czt.service.RelyService;
@Service
public class RelyServiceImpl implements RelyService {

	
	@Autowired
	private RelyMapper relyMapper;

	@Override
	public boolean insertCommentRely(Rely rely) {
		try {
			relyMapper.insertCommentRely(rely);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public boolean insertRelyRely(Rely rely) {
		try {
			relyMapper.insertRelyRely(rely);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	
		
	
	}

	@Override
	public List<Rely> searchAllRely() {
		
		// TODO Auto-generated method stub
		return relyMapper.searchAllRely();
	}

	@Override
	public List<Rely> findReliesByCommentId(Integer comment_id) {
		// TODO Auto-generated method stub
		return relyMapper.findReliesByCommentId(comment_id);
	}

	@Override
	public Rely findRelyById(Integer rely_id0) {
		// TODO Auto-generated method stub
		return relyMapper.findRelyById(rely_id0);
	}
}
