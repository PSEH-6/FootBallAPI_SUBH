package com.sapient.example.model;

import com.google.gson.annotations.SerializedName;

public class Standing {

	@SerializedName("league_id")
	private String id;

	@SerializedName("country_name")
	private String country;

	@SerializedName("league_name")
	private String name;

	@SerializedName("team_id")
	private String teamTd;

	@SerializedName("team_name")
	private String teamName;

	@SerializedName("overall_league_position")
	private String overallLeaguePosition;

	@SerializedName("overall_league_payed")
	private String overallLeaguePlayed;

	@SerializedName("overall_league_W")
	private String overallLeagueWon;

	@SerializedName("overall_league_D")
	private String overallLeagueDraw;

	@SerializedName("overall_league_L")
	private String overallLeagueLost;

	@SerializedName("overall_league_GF")
	private String overallLeagueGF;

	@SerializedName("overall_league_GA")
	private String overallLeagueGA;

	@SerializedName("overall_league_PTS")
	private String overallLeaguePoints;

	@SerializedName("home_league_position")
	private String homeLeaguePosition;

	@SerializedName("home_league_payed")
	private String homeLeaguePlayed;

	@SerializedName("home_league_W")
	private String homeLeagueWon;

	@SerializedName("home_league_D")
	private String homeLeagueDraw;

	@SerializedName("home_league_L")
	private String homeLeagueLost;

	@SerializedName("home_league_GF")
	private String homeLeagueGF;

	@SerializedName("home_league_GA")
	private String homeLeagueGA;

	@SerializedName("home_league_PTS")
	private String homeLeaguePoints;

	@SerializedName("away_league_position")
	private String awayLeaguePosition;

	@SerializedName("away_league_payed")
	private String awayLeaguePlayed;

	@SerializedName("away_league_W")
	private String awayLeagueWon;

	@SerializedName("away_league_D")
	private String awayLeagueDraw;

	@SerializedName("away_league_L")
	private String awayLeagueLost;

	@SerializedName("away_league_GF")
	private String awayLeagueGF;

	@SerializedName("away_league_GA")
	private String awayLeagueGA;

	@SerializedName("away_league_PTS")
	private String awayLeaguePoints;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamTd() {
		return teamTd;
	}

	public void setTeamTd(String teamTd) {
		this.teamTd = teamTd;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOverallLeaguePosition() {
		return overallLeaguePosition;
	}

	public void setOverallLeaguePosition(String overallLeaguePosition) {
		this.overallLeaguePosition = overallLeaguePosition;
	}

	public String getOverallLeaguePlayed() {
		return overallLeaguePlayed;
	}

	public void setOverallLeaguePlayed(String overallLeaguePlayed) {
		this.overallLeaguePlayed = overallLeaguePlayed;
	}

	public String getOverallLeagueWon() {
		return overallLeagueWon;
	}

	public void setOverallLeagueWon(String overallLeagueWon) {
		this.overallLeagueWon = overallLeagueWon;
	}

	public String getOverallLeagueDraw() {
		return overallLeagueDraw;
	}

	public void setOverallLeagueDraw(String overallLeagueDraw) {
		this.overallLeagueDraw = overallLeagueDraw;
	}

	public String getOverallLeagueLost() {
		return overallLeagueLost;
	}

	public void setOverallLeagueLost(String overallLeagueLost) {
		this.overallLeagueLost = overallLeagueLost;
	}

	public String getOverallLeagueGF() {
		return overallLeagueGF;
	}

	public void setOverallLeagueGF(String overallLeagueGF) {
		this.overallLeagueGF = overallLeagueGF;
	}

	public String getOverallLeagueGA() {
		return overallLeagueGA;
	}

	public void setOverallLeagueGA(String overallLeagueGA) {
		this.overallLeagueGA = overallLeagueGA;
	}

	public String getOverallLeaguePoints() {
		return overallLeaguePoints;
	}

	public void setOverallLeaguePoints(String overallLeaguePoints) {
		this.overallLeaguePoints = overallLeaguePoints;
	}

	public String getHomeLeaguePosition() {
		return homeLeaguePosition;
	}

	public void setHomeLeaguePosition(String homeLeaguePosition) {
		this.homeLeaguePosition = homeLeaguePosition;
	}

	public String getHomeLeaguePlayed() {
		return homeLeaguePlayed;
	}

	public void setHomeLeaguePlayed(String homeLeaguePlayed) {
		this.homeLeaguePlayed = homeLeaguePlayed;
	}

	public String getHomeLeagueWon() {
		return homeLeagueWon;
	}

	public void setHomeLeagueWon(String homeLeagueWon) {
		this.homeLeagueWon = homeLeagueWon;
	}

	public String getHomeLeagueDraw() {
		return homeLeagueDraw;
	}

	public void setHomeLeagueDraw(String homeLeagueDraw) {
		this.homeLeagueDraw = homeLeagueDraw;
	}

	public String getHomeLeagueLost() {
		return homeLeagueLost;
	}

	public void setHomeLeagueLost(String homeLeagueLost) {
		this.homeLeagueLost = homeLeagueLost;
	}

	public String getHomeLeagueGF() {
		return homeLeagueGF;
	}

	public void setHomeLeagueGF(String homeLeagueGF) {
		this.homeLeagueGF = homeLeagueGF;
	}

	public String getHomeLeagueGA() {
		return homeLeagueGA;
	}

	public void setHomeLeagueGA(String homeLeagueGA) {
		this.homeLeagueGA = homeLeagueGA;
	}

	public String getHomeLeaguePoints() {
		return homeLeaguePoints;
	}

	public void setHomeLeaguePoints(String homeLeaguePoints) {
		this.homeLeaguePoints = homeLeaguePoints;
	}

	public String getAwayLeaguePosition() {
		return awayLeaguePosition;
	}

	public void setAwayLeaguePosition(String awayLeaguePosition) {
		this.awayLeaguePosition = awayLeaguePosition;
	}

	public String getAwayLeaguePlayed() {
		return awayLeaguePlayed;
	}

	public void setAwayLeaguePlayed(String awayLeaguePlayed) {
		this.awayLeaguePlayed = awayLeaguePlayed;
	}

	public String getAwayLeagueWon() {
		return awayLeagueWon;
	}

	public void setAwayLeagueWon(String awayLeagueWon) {
		this.awayLeagueWon = awayLeagueWon;
	}

	public String getAwayLeagueDraw() {
		return awayLeagueDraw;
	}

	public void setAwayLeagueDraw(String awayLeagueDraw) {
		this.awayLeagueDraw = awayLeagueDraw;
	}

	public String getAwayLeagueLost() {
		return awayLeagueLost;
	}

	public void setAwayLeagueLost(String awayLeagueLost) {
		this.awayLeagueLost = awayLeagueLost;
	}

	public String getAwayLeagueGF() {
		return awayLeagueGF;
	}

	public void setAwayLeagueGF(String awayLeagueGF) {
		this.awayLeagueGF = awayLeagueGF;
	}

	public String getAwayLeagueGA() {
		return awayLeagueGA;
	}

	public void setAwayLeagueGA(String awayLeagueGA) {
		this.awayLeagueGA = awayLeagueGA;
	}

	public String getAwayLeaguePoints() {
		return awayLeaguePoints;
	}

	public void setAwayLeaguePoints(String awayLeaguePoints) {
		this.awayLeaguePoints = awayLeaguePoints;
	}

}
