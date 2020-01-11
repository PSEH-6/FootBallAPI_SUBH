package com.sapient.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.example.model.FootballApi;
import com.sapient.example.model.Player;
import com.sapient.example.repository.PlayerRepository;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class PlayerService {

	@Autowired
	private FootballApi footballApi;

	@Autowired
	private PlayerRepository playerRepository;
	
	public Player getPlayer(int playerId) throws IOException {
		Call<Player> playerRequest = playerRepository.getPlayer(footballApi.getApiKey(), playerId);
		Response<Player> response = playerRequest.execute();
		Player player = response.body();
		return player;
	}

	public List<Player> getPlayer(String name) throws IOException {
		Call<List<Player>> playerRequest = playerRepository.getPlayer(footballApi.getApiKey(), name);
		Response<List<Player>> response = playerRequest.execute();
		List<Player> players = response.body();
		return players;
	}
}
