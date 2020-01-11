package com.sapient.example.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Country {

	@SerializedName("country_id")
	private int id;

	@SerializedName("country_name")
	private String name;

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

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Country other = (Country) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
}
