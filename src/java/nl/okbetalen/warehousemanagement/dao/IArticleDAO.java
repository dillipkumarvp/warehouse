package nl.okbetalen.warehousemanagement.dao;

import java.util.List;

import nl.okbetalen.warehousemanagement.entity.Article;

/**
 * 
 * @author dillipkumar.vp
 *
 */

public interface IArticleDAO {
	
	/**
	 * Fetch all Availble article
	 * 
	 * @return List<Article>
	 */
	List<Article> getAllArticles();

	/**
	 * Get a Article for the given ID
	 * 
	 * @param articleId
	 * @return Article
	 */
	Article getArticleById(int articleId);

	/**
	 * Add new Article
	 * 
	 * @param article
	 */
	void addArticle(Article article);

	/**
	 * Update the exisiting Article
	 * @param article
	 */
	void updateArticle(Article article);

	/**
	 * Delete a given Article by ID 
	 * 
	 * @param articleId
	 */
	void deleteArticle(int articleId);

	/**
	 * Check whether Article Exist
	 * 
	 * @param title
	 * @param category
	 * @return boolean
	 */
	boolean articleExists(String title, String category);
}
