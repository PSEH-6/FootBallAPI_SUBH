package com.sapient.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sapient.example.model.FootballApi;
import com.sapient.example.repository.CountryRepository;
import com.sapient.example.repository.LeagueRepository;
import com.sapient.example.repository.PlayerRepository;
import com.sapient.example.repository.StandingRepository;
import com.sapient.example.repository.TeamRepository;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

	@Bean
	public FootballApi footballApi(@Value("${apifootball.url}") String url, @Value("${apifootball.apiKey}") String apiKey) {
		return new FootballApi(url, apiKey);
	}

	@Bean
	public Retrofit retrofit(FootballApi footballApi) {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(footballApi.getUrl())
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.build())
				.build();

		return retrofit;
	}

	@Bean
	public CountryRepository countryRepository(Retrofit retrofit) {
		return retrofit.create(CountryRepository.class);
	}

	@Bean
	public LeagueRepository leagueRepository(Retrofit retrofit) {
		return retrofit.create(LeagueRepository.class);
	}

	@Bean
	public PlayerRepository playerRepository(Retrofit retrofit) {
		return retrofit.create(PlayerRepository.class);
	}

	@Bean
	public StandingRepository standingRepository(Retrofit retrofit) {
		return retrofit.create(StandingRepository.class);
	}

	@Bean
	public TeamRepository teamRepository(Retrofit retrofit) {
		return retrofit.create(TeamRepository.class);
	}
}
