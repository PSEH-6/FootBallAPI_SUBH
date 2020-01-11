package com.sapient.example.model;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class Team {

	@SerializedName("team_key")
	private int key;

	@SerializedName("team_name")
	private String name;

	@SerializedName("team_badge")
	private String badge;

	@SerializedName("player_key")
	private List<Player> players;

	@SerializedName("player_key")
	private List<Coach> coaches;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Coach> getCoaches() {
		return coaches;
	}

	public void setCoaches(List<Coach> coaches) {
		this.coaches = coaches;
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
		Team other = (Team) obj;
		if (key != other.key) {
			return false;
		}
		return true;
	}
}
