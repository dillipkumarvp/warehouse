package nl.okbetalen.warehousemanagement.controller;

import java.util.List;

import nl.okbetalen.warehousemanagement.entity.Article;
import nl.okbetalen.warehousemanagement.service.IArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Controller class to handle all types of HTTP operations.
 * 
 * 1. PUT
 * 2. GET
 * 3. POST
 * 4. DELETE
 *  * 
 * @author dillipkumar.vp
 *
 */

@Controller
@RequestMapping("user")
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;

	/**
	 * Operation GET to the fetch the Article for the given ID
	 * 
	 * @param id
	 * @return Article
	 */
	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	/** 
	 * Operation GET to the fetch all Articles from the database
	 * 
	 * @return List<Article>
	 */
	@GetMapping("article")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}

	/**
	 * 
	 * Operation POST to ADD given Article to the database
	 * 
	 * @param article
	 * @param builder
	 * @return void
	 */
	@PostMapping("article")
	public ResponseEntity<Void> addArticle(@RequestBody Article article,
			UriComponentsBuilder builder) {
		boolean flag = articleService.addArticle(article);
		if (!flag) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/article/{id}")
				.buildAndExpand(article.getArticleId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	
	/**
	 * Operation PUT to UPDATE the given Article to the database
	 * 
	 * @param article
	 * @return Article
	 */
	
	@PutMapping("article")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	/**
	 * Operation DELETE to Remove the given Article to the database
	 * 
	 * @param id
	 * @return void
	 */
	@DeleteMapping("article/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}