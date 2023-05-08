package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents product type, with an id and a name.
 * The id and name can be set and retrieved using setter and getter methods.
 */
@Entity
@Table(name = "producttype")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ProductTypeId")
	private int productTypeId;
	@Column (name="name")
	private String name;
	
	public ProductType() {
		super();
	}

	public ProductType(int productTypeId, String name) {
		super();
		this.productTypeId = productTypeId;
		this.name = name;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
