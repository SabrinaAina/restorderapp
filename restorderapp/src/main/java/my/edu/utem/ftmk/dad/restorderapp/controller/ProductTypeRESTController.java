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

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductTypeRepository;

/**
 * Controller class for handling requests related to product type.
 * This class maps HTTP requests to appropriate methods and returns a response to the client.
 * This class contains method to retrieve, insert, update and delete product type informations. 
 */

@RestController
@RequestMapping("/api/producttypes")
public class ProductTypeRESTController {
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	// Retrieves a list of all ProductTypes from the database
	@GetMapping
	public List<ProductType> getProductTypes() {
		return productTypeRepository.findAll();
	}
	
	// Retrieve a product type by its ID
	@GetMapping("{productTypeId}")
	public ProductType getProductType(@PathVariable long productTypeId) {
		
		ProductType productType = productTypeRepository.findById(productTypeId).get();
		return productType;
	}
	
	// Inserts a new product type into the database
	@PostMapping()
	public ProductType insertProductType(@RequestBody ProductType productType) {
		return productTypeRepository.save(productType);
		
	}
	
	// Updates the product type for the specified product type.
	@PutMapping()
	public ProductType updateProductType(@RequestBody ProductType productType) {
		return productTypeRepository.save(productType);
	}

	// Delete the product type by its Id.
	@DeleteMapping("{productTypeId}")
	public ResponseEntity<HttpStatus> deleteProductType(@PathVariable long productTypeId) {
		
		productTypeRepository.deleteById(productTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
