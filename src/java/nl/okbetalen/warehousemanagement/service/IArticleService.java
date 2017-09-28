package nl.okbetalen.warehousemanagement.service;

import java.util.List;

import nl.okbetalen.warehousemanagement.entity.Article;

import org.springframework.security.access.annotation.Secured;

/**
 * Role based setting for access the operations. 
 * 
 * @author dillipkumar.vp
 *
 */
public interface IArticleService {
	
	/**
	 * Fetch All Articles
	 * @return List<Article>
	 */
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<Article> getAllArticles();
	 
	 /**
	  * Get Article by ID
	  * @param articleId
	  * @return Article
	  */
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     Article getArticleById(int articleId);
	 
	 /**
	  * Add new Article
	  * @param article
	  * @return boolean
	  */
	 @Secured ({"ROLE_ADMIN"})
     boolean addArticle(Article article);
	 
	 /**
	  * Update Existing Article
	  * @param article
	  */
	 @Secured ({"ROLE_ADMIN"})
     void updateArticle(Article article);
	 
	 /**
	  * Delete a Article by ID.
	  * @param articleId
	  */
	 @Secured ({"ROLE_ADMIN"})
     void deleteArticle(int articleId);
}
