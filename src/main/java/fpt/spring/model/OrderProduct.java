package fpt.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "orderproduct")
@NamedQuery(name="OrderProduct.findAll", query="SELECT w FROM OrderProduct w")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;
	
	private int quantity;
	
	private int total;
	
	@ManyToOne
    @JoinColumn(name="oid", nullable=false)
	private Orders orders;
	
	@ManyToOne
    @JoinColumn(name="cid", nullable=false)
	private Category category;

	public OrderProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OrderProduct(String code, int quantity, int total) {
		super();
		this.code = code;
		this.quantity = quantity;
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", code=" + code + ", quantity=" + quantity + ", total=" + total + ", orders="
				+ orders + "]";
	}

}