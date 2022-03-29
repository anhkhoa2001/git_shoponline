package fpt.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account {
	
	private String username;

	private String address;

	private String role;

	private String date;

	private String email;

	@Id
	private int id;

	private String name;

	private String password;

	private String phone;

	public Account() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", address=" + address + ", role=" + role + ", date=" + date
				+ ", email=" + email + ", id=" + id + ", name=" + name + ", password=" + password
				+ ", phone=" + phone + "]";
	}

	public Account(String username, String address, String role, String date, String email, 
			String name, String password, String phone) {
		super();
		this.username = username;
		this.address = address;
		this.role = role;
		this.date = date;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	
}