package com.sapient.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.example.model.FootballApi;
import com.sapient.example.model.League;
import com.sapient.example.repository.LeagueRepository;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class LeagueService {

	@Autowired
	private FootballApi footballApi;

	@Autowired
	private LeagueRepository leagueRepository;

	public List<League> getAllLeagues() throws IOException {
		Call<List<League>> leagueRequest = leagueRepository.getAllLeagues(footballApi.getApiKey());
		Response<List<League>> response = leagueRequest.execute();
		List<League> leagues = response.body();
		return leagues;
	}

	public List<League> getLeague(int countryId) throws IOException {
		Call<List<League>> leagueRequest = leagueRepository.getLeagues(footballApi.getApiKey(), countryId);
		Response<List<League>> response = leagueRequest.execute();
		List<League> league = response.body();
		return league;
	}
}
