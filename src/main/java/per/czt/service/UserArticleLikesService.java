package per.czt.service;
import per.czt.pojo.UserArticleLikes;

public interface UserArticleLikesService {
	public boolean insertUserArticleLikes(UserArticleLikes userArticleLikes);
	public boolean deleteUserArticleLikesById(Integer user_article_likes_id );
	
	public UserArticleLikes searchOneUserArticleLikes(int user_article_likes_id);
	public Integer getArticleLikesCounts(Integer user_id);

}
