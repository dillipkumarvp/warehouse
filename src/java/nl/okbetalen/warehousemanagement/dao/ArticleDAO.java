package nl.okbetalen.warehousemanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import nl.okbetalen.warehousemanagement.entity.Article;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author dillipkumar.vp
 *
 */

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IArticleDAO#getArticleById(int)
	 */
	@Override
	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IArticleDAO#getAllArticles()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IArticleDAO#addArticle(nl.okbetalen.warehousemanagement.entity.Article)
	 */
	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);
	}

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IArticleDAO#updateArticle(nl.okbetalen.warehousemanagement.entity.Article)
	 */
	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setVolume(article.getVolume());
		entityManager.flush();
	}

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IArticleDAO#deleteArticle(int)
	 */
	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}

	/*
	 * (non-Javadoc)
	 * @see nl.okbetalen.warehousemanagement.dao.IArticleDAO#articleExists(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
				.setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}
