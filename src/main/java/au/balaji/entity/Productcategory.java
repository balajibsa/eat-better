package au.balaji.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Productcategory.findAll", query="SELECT p FROM Productcategory p")
public class Productcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
 
	@OneToOne
	@JoinColumn(name="category_id")
	private Category category;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public Productcategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}