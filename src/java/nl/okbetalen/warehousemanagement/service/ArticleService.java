package nl.okbetalen.warehousemanagement.service;

import java.util.List;

import nl.okbetalen.warehousemanagement.dao.IArticleDAO;
import nl.okbetalen.warehousemanagement.entity.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation class to Manage the Articles.
 * 
 * @author dillipkumar.vp
 *
 */

@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	private IArticleDAO articleDAO;
	
	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.service.IArticleService#getArticleById(int)
	 */
	@Override
	public Article getArticleById(int articleId) {
		return  articleDAO.getArticleById(articleId);
	}	
	
	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.service.IArticleService#getAllArticles()
	 */
	@Override
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	
	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.service.IArticleService#addArticle(nl.okbetalen.warehousemanagement.entity.Article)
	 */
	@Override
	public synchronized boolean addArticle(Article article){
       if (articleDAO.articleExists(article.getTitle(), article.getVolume())) {
    	   return false;
       } else {
    	   articleDAO.addArticle(article);
    	   return true;
       }
	}
	
	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.service.IArticleService#updateArticle(nl.okbetalen.warehousemanagement.entity.Article)
	 */
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	
	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.service.IArticleService#deleteArticle(int)
	 */
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
