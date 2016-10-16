package au.balaji.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descrition;

	private String name;

	private BigDecimal price;

	// bi-directional one-to-one association to Currency
	@OneToOne
	@JoinColumn(name="currency_id")
	private Currency currency;

	// bi-directional one-to-one association to Image
	@OneToOne
	@JoinColumn(name = "image_id")
	private Image image;
 
	@OneToMany
	private List<Productcategory> productcategories;
 
	@OneToMany
	private List<Producttime> producttimes;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrition() {
		return this.descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Productcategory> getProductcategories() {
		return this.productcategories;
	}

	public void setProductcategories(List<Productcategory> productcategories) {
		this.productcategories = productcategories;
	}

	public Productcategory addProductcategory(Productcategory productcategory) {
		getProductcategories().add(productcategory);
		productcategory.setProduct(this);

		return productcategory;
	}

	public Productcategory removeProductcategory(Productcategory productcategory) {
		getProductcategories().remove(productcategory);
		productcategory.setProduct(null);

		return productcategory;
	}

	public List<Producttime> getProducttimes() {
		return this.producttimes;
	}

	public void setProducttimes(List<Producttime> producttimes) {
		this.producttimes = producttimes;
	}

	public Producttime addProducttime(Producttime producttime) {
		getProducttimes().add(producttime);
		producttime.setProduct(this);

		return producttime;
	}

	public Producttime removeProducttime(Producttime producttime) {
		getProducttimes().remove(producttime);
		producttime.setProduct(null);

		return producttime;
	}

}