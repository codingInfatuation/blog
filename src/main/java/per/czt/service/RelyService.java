package per.czt.service;

import java.util.List;

import per.czt.pojo.Comment;
import per.czt.pojo.Rely;

public interface RelyService {
	public boolean insertCommentRely(Rely rely);
	public boolean insertRelyRely(Rely rely);
	public List<Rely> searchAllRely();
	public List<Rely> findReliesByCommentId(Integer comment_id);
	public Rely findRelyById(Integer rely_id0);

}
