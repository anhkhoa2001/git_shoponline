package fpt.spring.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="catemenu")
@NamedQuery(name = "Catemenu.findAll", query = "SELECT u FROM Catemenu u")
public class Catemenu{

	@Id
	private int id;

	private String icon;

	private String image;

	private String line;

	private String slogan;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="catemenu")
    private Set<Category> categories;

	public Catemenu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLine() {
		return this.line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Catemenu(String icon, String image, String line, String slogan) {
		super();
		this.icon = icon;
		this.image = image;
		this.line = line;
		this.slogan = slogan;
	}

	@Override
	public String toString() {
		return "Catemenu [id=" + id + ", icon=" + icon + ", image=" + image + ", line=" + line + ", slogan=" + slogan
				+ "]";
	}
	
	

}