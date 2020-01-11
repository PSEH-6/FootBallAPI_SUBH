package com.sapient.example.model;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

public class Coach {

	@SerializedName("coach_name")
	private String name;

	@SerializedName("coach_country")
	private String country;

	@SerializedName("coach_age")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ", " + country;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(age, country, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Coach other = (Coach) obj;
		if (age != other.age || !Objects.equal(country, other.country) || !Objects.equal(name, other.name)) {
			return false;
		}
		return true;
	}

}
