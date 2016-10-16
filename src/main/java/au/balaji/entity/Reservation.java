package au.balaji.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Transient
	private String comment;

	@Transient
	private String day;

	@Transient
	private String month;

	@Transient
	private String year;

	@Transient
	private String hour;

	@Transient
	private String minute;

	@Transient
	private String ampm;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String email;

	private String lname;

	private String name;

	private int noOfGuests;

	private String occasion;

	private String phone;

	public Reservation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		int hr = Integer.parseInt(hour);
		if (ampm.equals("pm") && !hour.equals("12")) {
			hr = hr + 12;
		} else if (ampm.equals("pm") && hour.equals("12")) {
			hr = 0;
		}

		String dateStr = day + "/" + month + "/" + year + "/" + appendForHour(hr) + "/" + minute;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mi");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String appendForHour(int input) {
		if (input < 10) {
			return "0" + String.valueOf(input);
		} else {
			return String.valueOf(input);
		}
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfGuests() {
		return this.noOfGuests;
	}

	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public String getOccasion() {
		return this.occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getAmpm() {
		return ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}

}