package com.sapient.example.repository;

import java.util.List;

import com.sapient.example.model.Standing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StandingRepository {

	@GET("?action=get_standings")
	public Call<List<Standing>> getStandings(@Query("APIkey") String apiKey, @Query("league_id") int leagueId);

}
