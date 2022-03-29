package fpt.spring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="orders")
@NamedQuery(name="Orders.findAll", query="SELECT o FROM Orders o")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private int quantity;

	private String created;

	private int total;
	
	private boolean status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="orders")
    private Set<OrderProduct> orderProducts;

	public Orders() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Orders(String name, String email, String phone, String address, int quantity, String created, int total) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.quantity = quantity;
		this.created = created;
		this.total = total;
	}
	
	public Orders(String name, String email, String phone, String address, int quantity, 
			String created, int total, boolean status) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.quantity = quantity;
		this.created = created;
		this.total = total;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", quantity=" + quantity + ", created=" + created + ", total=" + total + ", status=" + status + "]";
	}

}