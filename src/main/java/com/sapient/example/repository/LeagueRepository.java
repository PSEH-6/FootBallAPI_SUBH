package com.sapient.example.repository;

import java.util.List;

import com.sapient.example.model.League;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LeagueRepository {

	@GET("?action=get_leagues")
	public Call<List<League>> getAllLeagues(@Query("APIkey") String apiKey);

	@GET("?action=get_leagues")
	public Call<List<League>> getLeagues(@Query("APIkey") String apiKey, @Query("country_id") int countryId);

}
