package com.sapient.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.example.model.FootballApi;
import com.sapient.example.model.Standing;
import com.sapient.example.repository.StandingRepository;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class StandingService {

	@Autowired
	private FootballApi footballApi;

	@Autowired
	private StandingRepository standingRepository;

	public List<Standing> getStandings(int leagueId) throws IOException {
		Call<List<Standing>> standingRequest = standingRepository.getStandings(footballApi.getApiKey(), leagueId);
		Response<List<Standing>> response = standingRequest.execute();
		List<Standing> standings = response.body();
		return standings;
	}
}
