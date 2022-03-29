package fpt.spring.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import fpt.spring.main.Main;

@MappedSuperclass
public abstract class Product {
	
	private String code;
	
	private String name;
	
	private int price;
	
	private int quantityStock;
	
	private String image;
	
	@ManyToOne
    @JoinColumn(name="cid", nullable=false)
	private Category category;

	public int getPrice() {
		return price;
	}
	
	public int getPriceDola() {
		return price/Main.dola;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product() {
		super();
	}

	public Product(String code, String name, int price, int quantityStock, String image) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantityStock = quantityStock;
		this.image = image;
	}

	public int getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", quantityStock=" + quantityStock + ", image="
				+ image + "]";
	}

	
}
