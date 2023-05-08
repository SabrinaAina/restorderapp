package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents order type, with an id, a code and a name.
 * The id, code and name can be set and retrieved using setter and getter methods.
 */

@Entity
@Table(name = "ordertype")
public class OrderType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="OrderTypeId")
	private int orderTypeId;
	@Column (name="Code")
	private String code;
	@Column (name="Name")
	private String name;
	
	public OrderType() {
		super();
	}
	
	public OrderType(int orderTypeId, String code, String name) {
		super();
		this.orderTypeId = orderTypeId;
		this.code = code;
		this.name = name;
	}
	public int getOrderTypeId() {
		return orderTypeId;
	}
	public void setOrderTypeId(int orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}