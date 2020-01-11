package com.sapient.example.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Player {

	@SerializedName("player_key")
	private String key;

	@SerializedName("player_name")
	private String name;

	@SerializedName("player_number")
	private int number;

	@SerializedName("player_country")
	private String country;

	@SerializedName("player_type")
	private String type;

	@SerializedName("player_age")
	private int age;

	@SerializedName("player_match_played")
	private int matchPlayed;

	@SerializedName("player_goals")
	private int goals;

	@SerializedName("player_yellow_cards")
	private int yellowCards;

	@SerializedName("player_red_cards")
	private int redCards;

	@SerializedName("team_name")
	private String teamName;

	@SerializedName("team_key")
	private String teamKey;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public void setYellowCards(int yellowCards) {
		this.yellowCards = yellowCards;
	}

	public int getRedCards() {
		return redCards;
	}

	public void setRedCards(int redCards) {
		this.redCards = redCards;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamKey() {
		return teamKey;
	}

	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}

	@Override
	public String toString() {
		return name + ", " + country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Player other = (Player) obj;
		return Objects.equals(key, other.key);
	}
}
