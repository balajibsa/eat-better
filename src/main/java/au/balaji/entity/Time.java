package au.balaji.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the times database table.
 * 
 */
@Entity
@Table(name = "times")
@NamedQuery(name = "Time.findAll", query = "SELECT t FROM Time t")
public class Time implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String days;

	private String name;

	private String time;

	// bi-directional many-to-one association to Producttime
	@OneToMany(mappedBy = "time")
	private List<Producttime> producttimes;

	@OneToOne
	@JoinColumn(name = "image_id")
	private Image image;

	public Time() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDays() {
		return this.days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Producttime> getProducttimes() {
		return this.producttimes;
	}

	public void setProducttimes(List<Producttime> producttimes) {
		this.producttimes = producttimes;
	}

	public Producttime addProducttime(Producttime producttime) {
		getProducttimes().add(producttime);
		producttime.setTime(this);

		return producttime;
	}

	public Producttime removeProducttime(Producttime producttime) {
		getProducttimes().remove(producttime);
		producttime.setTime(null);

		return producttime;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}