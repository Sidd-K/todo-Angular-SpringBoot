package com.fullstackpractice.fullstackpractice.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class todoBean {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String description;
	private Date date;
	private boolean isDone;
	
	public todoBean() {
		super();
	}

	public todoBean(int id, String name, String description, Date date, boolean isDone) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		todoBean other = (todoBean) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
