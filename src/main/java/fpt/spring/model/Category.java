package fpt.spring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
@NamedQuery(name = "Category.findAll", query = "SELECT u FROM Category u")
public class Category {
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="category")
    private Set<PhoneTab> phoneTabs;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="category")
    private Set<Laptop> laptops;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="category")
    private Set<OrderProduct> orderProducts;
	
	@Id
	private int id;

	@ManyToOne
    @JoinColumn(name="cmID", nullable=false)
	private Catemenu catemenu;

	private String code;

	private String line;

	private String logo;

	private int manuID;

	public Category() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getManuID() {
		return this.manuID;
	}

	public void setManuID(int manuID) {
		this.manuID = manuID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getSizePhoneTabs() {
		return phoneTabs.size();
	}
	
	public int getSizeLaptops() {
		return laptops.size();
	}

	public Catemenu getCatemenu() {
		return catemenu;
	}

	public void setCatemenu(Catemenu catemenu) {
		this.catemenu = catemenu;
	}

	@Override
	public String toString() {
		return "Category [id=" + id  + ", code=" + code + ", line=" + line + ", logo=" + logo
				+ ", manuID=" + manuID + "]";
	}

}