package au.balaji.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String uri;

	public Image() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}