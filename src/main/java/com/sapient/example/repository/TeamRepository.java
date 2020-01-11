package com.sapient.example.repository;

import java.util.List;

import com.sapient.example.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamRepository {

	@GET("?action=get_teams")
	public Call<List<Team>> getTeams(@Query("APIkey") String apiKey, @Query("league_id") int leagueId);

	@GET("?action=get_teams")
	public Call<Team> getTeam(@Query("APIkey") String apiKey, @Query("team_id") int teamId);
}
