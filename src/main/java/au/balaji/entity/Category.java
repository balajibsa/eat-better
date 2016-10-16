package au.balaji.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional one-to-one association to Productcategory
	@OneToOne
	@JoinColumn(name="id", referencedColumnName="category_id")
	private Productcategory productcategory;

	public Category() {
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

	public Productcategory getProductcategory() {
		return this.productcategory;
	}

	public void setProductcategory(Productcategory productcategory) {
		this.productcategory = productcategory;
	}

}