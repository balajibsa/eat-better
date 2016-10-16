package au.balaji.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producttimes database table.
 * 
 */
@Entity
@Table(name="producttimes")
@NamedQuery(name="Producttime.findAll", query="SELECT p FROM Producttime p")
public class Producttime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
 
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
 
	@ManyToOne
	@JoinColumn(name="times_id")
	private Time time;

	public Producttime() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}