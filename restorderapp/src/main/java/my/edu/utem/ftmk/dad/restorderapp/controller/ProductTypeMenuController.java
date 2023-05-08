package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;

/**
 * This class manage the request from the front end 
 * and consume REST web service to manage the CRUD operation
 */
@Controller
public class ProductTypeMenuController {
	
	private String defaultURI = "http://localhost:8080/orderapp/api/producttypes";
	
	// This method consume a GET web service and display a list of record on the console.
	@GetMapping("/producttype/list")
	
	/*
	 * public ResponseEntity<String> getProductTypes() {
	 * 
	 * // The URI for GET order types String uri =
	 * "http://localhost:8080/orderapp/api/producttypes";
	 * 
	 * // Get a list order types from the web service RestTemplate restTemplate =
	 * new RestTemplate(); ResponseEntity<ProductType[]> response =
	 * restTemplate.getForEntity(uri, ProductType[].class);
	 * 
	 * // Parse JSON data to array of object ProductType productTypes[] =
	 * response.getBody();
	 * 
	 * // Generate message System.out.println(this.getClass().getSimpleName());
	 * System.out.println("Total records: " + productTypes.length + "\n");
	 * 
	 * // Display the records for (ProductType productType:productTypes) {
	 * 
	 * System.out.print(productType.getProductTypeId() + "-");
	 * System.out.print(productType.getName() + "\n"); }
	 * 
	 * // For Postman status String message =
	 * "Check out the message in the console"; return new ResponseEntity<>(message,
	 * HttpStatus.OK); }
	 */
	
	  public String getProductTypes(Model model) {
	  
		  // The URI for GET product types 
		  String uri = "http://localhost:8080/orderapp/api/producttypes";
		  
		  // Get a list order types from the web service 
		  RestTemplate restTemplate = new RestTemplate(); 
		  ResponseEntity<ProductType[]> response = restTemplate.getForEntity(uri, ProductType[].class);
		  
		  // Parse JSON data to array of object 
		  ProductType productTypes[] = response.getBody();
		  
		  // Parse an array to a list object 
		  List<ProductType> productTypeList = Arrays.asList(productTypes);
		  
		  // Attach list to model as attribute 
		  model.addAttribute("productTypes", productTypeList);
		  
		  return "producttypes"; 
	  }
	 
	
	/**
	 * This method will update or add an order type.
	 *
	 *@param productType
	 *@return
	 */
	@RequestMapping("/producttype/save")
	public String updateProductType(@ModelAttribute ProductType productType) {
		
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<ProductType> request = new HttpEntity<ProductType>(productType);
		
		String productTypeResponse = "";
		
		if(productType.getProductTypeId() > 0) {
			// This block update an new order type and
			
			// Send request as PUT
			restTemplate.put(defaultURI, request, ProductType.class);
			
		} else {
			// This block add a new order type
			
			// send request as POST
			productTypeResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(productTypeResponse);
		
		// Redirect request to display a list of order type
		return "redirect:/producttype/list";
	}
	
	/**
	 * This method gets an product type
	 *
	 *@param productTypeId
	 *@param model
	 *@return
	 */
	@GetMapping("/producttype/{productTypeId}")
	public String getProductType (@PathVariable Integer productTypeId, Model model) {
		
		String pageTitle = "New Product Type";
		ProductType productType = new ProductType();
		
		// This block get an order type to be updated
		if(productTypeId > 0) {
			
			// Generate new URI and append productTypeId to it
			String uri = defaultURI + "/" + productTypeId;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			productType = restTemplate.getForObject(uri, ProductType.class);
			
			// Give a new title to the page
			pageTitle = "Edit Product Type";
		}
		
		// Attach value to pass to front end
		model.addAttribute("productType", productType);
		model.addAttribute("pageTitle", pageTitle);
		
		return "producttypeinfo";
		
	}
	
	/**
	 * This method deletes an product type
	 *
	 *@param productTypeId
	 *@return
	 */
	@RequestMapping("/producttype/delete/{productTypeId}")
	public String deleteProductType(@PathVariable Integer productTypeId) {
		
		// Generate new URI, similar to the mapping in ProductTypeRESTController
		String uri = defaultURI + "/{productTypeId}";
		
		// Send a DELETE request and attach the value of productTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("productTypeId", Integer.toString(productTypeId)));
		
		return "redirect:/producttype/list";
	}
}
