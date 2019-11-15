package per.czt.service;

import java.util.List;




import per.czt.pojo.Comment;

public interface CommentService {
	public List<Comment> searchAllComments();
	public void insertComment(Comment comment);
	public void deleteCommentByArticleId(Integer article_id);
	public Comment findCommentById(Integer comment_id);
	public boolean deleteCommentById(Integer comment_id);
}
