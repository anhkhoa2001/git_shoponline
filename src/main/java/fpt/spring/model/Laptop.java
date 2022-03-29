package fpt.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
@NamedQuery(name="Laptop.findAll", query="SELECT l FROM Laptop l")
public class Laptop extends Product {
	
	@Id
	@Column(name = "laptop_id")
	private int laptop_id;
	
	@Column(name = "display")
	private String display;

	@Column(name = "memory")
	private String memory;
	
	@Column(name = "cpu")
	private String cpu;

	@Column(name = "ram")
	private String ram;

	@Column(name = "card")
	private String card;
	
	@Column(name = "weight")
	private float weight;

	@Column(name = "size")
	private String size;

	public int getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Laptop() {
		super();
	}

	public Laptop(int laptop_id, String code, String name, int price, String image, String display, String memory,
			String cpu, String ram, String card, float weight, String size, int quantityStock) {
		super(code, name, price, quantityStock , image);
		this.laptop_id = laptop_id;
		this.display = display;
		this.memory = memory;
		this.cpu = cpu;
		this.ram = ram;
		this.card = card;
		this.weight = weight;
		this.size = size;
	}

	public Laptop(String name, String code,  int price, int quantityStock, String display, String memory,
			String cpu, String ram, String card, float weight, String size, String image) {
		super(code, name, price, quantityStock, image);
		this.display = display;
		this.memory = memory;
		this.cpu = cpu;
		this.ram = ram;
		this.card = card;
		this.weight = weight;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", display=" + display + ", memory=" + memory + ", cpu=" + cpu
				+ ", ram=" + ram + ", card=" + card + ", weight=" + weight + ", size=" + size + ", getPriceDola()="
				+ getPriceDola() + ", getImage()=" + getImage() + ", getName()=" + getName() + ", getCode()="
				+ getCode() + ", getQuantityStock()=" + getQuantityStock() + "]";
	}

}