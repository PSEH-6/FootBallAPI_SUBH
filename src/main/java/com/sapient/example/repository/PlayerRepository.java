package com.sapient.example.repository;

import java.util.List;

import com.sapient.example.model.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlayerRepository {

	@GET("?action=get_players")
	public Call<Player> getPlayer(@Query("APIkey") String apiKey, @Query("player_id") int playerId);

	@GET("?action=get_players")
	public Call<List<Player>> getPlayer(@Query("APIkey") String apiKey, @Query("player_name") String name);
}
