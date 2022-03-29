package fpt.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="phonelines")
@NamedQuery(name = "PhoneTab.findAll", query = "SELECT u FROM PhoneTab u")
public class PhoneTab extends Product {
	
	@Id
	@Column(name = "phonetab_id")
	private int phonetab_id;
	
	@Column(name = "screen")
	private String screen;
	
	@Column(name = "frontCamera")
	private String frontCamera;

	@Column(name = "backCamera")
	private String backCamera;

	@Column(name = "chip")
	private String chip;

	@Column(name = "memory")
	private String memory;

	@Column(name = "ram")
	private String ram;

	public String getBackCamera() {
		return this.backCamera;
	}

	public void setBackCamera(String backCamera) {
		this.backCamera = backCamera;
	}

	public String getChip() {
		return this.chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getFrontCamera() {
		return this.frontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}

	public String getMemory() {
		return this.memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getScreen() {
		return this.screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public int getPhonetab_id() {
		return phonetab_id;
	}

	public void setPhonetab_id(int phonetab_id) {
		this.phonetab_id = phonetab_id;
	}

	public PhoneTab(int phonetab_id, String code, String name, int price, String image,  String screen,
			String frontCamera, String backCamera, String chip, String memory, String ram, int quantityStock) {
		super(code, name, price, quantityStock, image);
		this.phonetab_id = phonetab_id;
		this.screen = screen;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
		this.chip = chip;
		this.memory = memory;
		this.ram = ram;
	}

	
	public PhoneTab(String name, String code, int price, int quantityStock, String screen,
			String frontCamera, String backCamera, String chip, String memory, String ram, String image) {
		super(code, name, price, quantityStock, image);
		this.screen = screen;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
		this.chip = chip;
		this.memory = memory;
		this.ram = ram;
	}

	public PhoneTab() {
		super();
	}

	@Override
	public String toString() {
		return "PhoneTab [phonetab_id=" + phonetab_id + ", screen=" + screen + ", frontCamera=" + frontCamera
				+ ", backCamera=" + backCamera + ", chip=" + chip + ", memory=" + memory + ", ram=" + ram
				+ ", getPriceDola()=" + getPriceDola() + ", getImage()=" + getImage() + ", getName()=" + getName()
				+ ", getCode()=" + getCode() + ", getQuantityStock()=" + getQuantityStock() + "]";
	}

	
	

}