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

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;
import my.edu.utem.ftmk.dad.restorderapp.repository.OrderTypeRepository;


/**
 * Controller class for handling requests related to order type.
 * This class maps HTTP requests to appropriate methods and returns a response to the client.
 * This class contains method to retrieve, insert, update and delete order type informations. 
 */
@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController {
	
	@Autowired
	private OrderTypeRepository orderTypeRepository;
	
	// Retrieves a list of all OrderType from the database
	@GetMapping
	public List<OrderType> getOrderTypes() {
		return orderTypeRepository.findAll();
	}
	
	// Retrieve an order type by its ID
	@GetMapping("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId) {
		
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		return orderType;
	}
	
	/**
	 * This method find order type data according to the order type's name.
	 * 
	 * @param orderType
	 * @return A list of order types record
	 */
	@RequestMapping("/find/name")
	public List<OrderType> findOrderType(@RequestBody OrderType orderType) {
		
		List<OrderType> orderTypes = 
				orderTypeRepository.findByNameContaining(orderType.getName());
		
		return orderTypes;
		
	}
	
	// Inserts a new order type into the database
	@PostMapping()
	public OrderType insertOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
		
	}
	
	// Updates the order type for the specified order type.
	@PutMapping()
	public OrderType updateOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	// Delete the order type by its Id.
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId) {
		
		orderTypeRepository.deleteById(orderTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}