package jfonferko.genuitek.activity.domain;

/**
 * Created by JFonferko on 2016-08-17.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "activity")
@XmlRootElement
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "username")
	private String username;

	@NotNull
	@Column(name = "data")
	private Date date;

	@NotNull
	@Column(name = "time")
	private int time;

	public Activity() {
	}

	public Activity(String username, Date date, int time) {
		this.username = username;
		this.date = date;
		this.time = time;
	}

	public Activity(int id, String username, Date data, int time) {
		this.id = id;
		this.username = username;
		this.date = data;
		this.time = time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Activity activity = (Activity) o;

		return id == activity.id;

	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}
}
