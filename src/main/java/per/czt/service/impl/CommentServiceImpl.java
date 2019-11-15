package per.czt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.CommentMapper;
import per.czt.pojo.Article;
import per.czt.pojo.Comment;
import per.czt.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> searchAllComments() {
		// TODO Auto-generated method stub
		return commentMapper.searchAllComments();
	}

	@Override
	public void insertComment(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.insertComment(comment);
	}

	@Override
	public void deleteCommentByArticleId(Integer article_id) {
		// TODO Auto-generated method stub
		commentMapper.deleteCommentByArticleId(article_id);
	}

	@Override
	public Comment findCommentById(Integer comment_id) {
		// TODO Auto-generated method stub
		return commentMapper.findCommentById(comment_id);
	}

	@Override
	public boolean deleteCommentById(Integer comment_id) {
		try {
			commentMapper.deleteCommentById(comment_id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
}
