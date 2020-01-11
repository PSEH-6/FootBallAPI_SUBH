package com.sapient.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.example.model.FootballApi;
import com.sapient.example.model.Team;
import com.sapient.example.repository.TeamRepository;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class TeamService {

	@Autowired
	private FootballApi footballApi;

	@Autowired
	private TeamRepository teamRepository;

	public List<Team> getTeams(int leagueId) throws IOException {
		Call<List<Team>> teamRequest = teamRepository.getTeams(footballApi.getApiKey(), leagueId);
		Response<List<Team>> response = teamRequest.execute();
		List<Team> teams = response.body();
		return teams;
	}

	public Team getTeam(int teamId) throws IOException {
		Call<Team> teamRequest = teamRepository.getTeam(footballApi.getApiKey(), teamId);
		Response<Team> response = teamRequest.execute();
		Team team = response.body();
		return team;
	}
}
