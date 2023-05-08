package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents product, with an id, name, price and a product type.
 * The id, name, price and product type can be set and retrieved using setter and getter methods.
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ProductId")
	private int productId;
	@Column (name="name")
	private String name;
	@Column (name="price")
	private double price;
	@Column (name="ProductType")
	private int productType;
	
	
	public Product() {
		super();
	}

	public Product(int productId, String name, double price, int productType) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.productType = productType;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}
	
	
	
}
