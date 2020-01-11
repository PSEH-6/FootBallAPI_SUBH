package com.sapient.example.model;

import com.google.gson.annotations.SerializedName;

public class League {

	@SerializedName("league_id")
	private int id;

	@SerializedName("league_name")
	private String name;

	@SerializedName("country_id")
	private int countryId;

	@SerializedName("country_name")
	private String countryName;

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

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
