package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductRepository;

/**
 * Controller class for handling requests related to product.
 * This class maps HTTP requests to appropriate methods and returns a response to the client.
 * This class contains method to retrieve, insert, update and delete product informations. 
 */

@RestController
@RequestMapping("/api/products")
public class ProductRESTController {
	
	@Autowired
	private ProductRepository productRepository;
	
	// Retrieves a list of all Product from the database
	@GetMapping
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	
	// Retrieve a product by its ID
	@GetMapping("{productId}")
	public Product getProduct(@PathVariable long productId) {
		
		Product product = productRepository.findById(productId).get();
		return product;
	}
	
	// Inserts a new product into the database
	@PostMapping()
	public Product insertProduct(@RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	// Updates the product for the specified product.
	@PutMapping()
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	// Delete the product by its Id.
	@DeleteMapping("{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long productId) {
		
		productRepository.deleteById(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
