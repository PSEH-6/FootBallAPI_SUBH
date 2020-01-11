package com.sapient.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.example.model.Country;
import com.sapient.example.model.FootballApi;
import com.sapient.example.repository.CountryRepository;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class CountryService {

	@Autowired
	private FootballApi footballApi;

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAllCountries() throws IOException {
		Call<List<Country>> countryRequest = countryRepository.getAllCountries(footballApi.getApiKey());
		Response<List<Country>> response = countryRequest.execute();
		List<Country> countries = response.body();
		return countries;
	}

	public Optional<Country> getCountry(int id) throws IOException {
		List<Country> countries = getAllCountries();
		Optional<Country> country = countries.stream().filter(c -> c.getId() == id).findFirst();
		return country;
	}

	public Optional<Country> getCountry(String name) throws IOException {
		List<Country> countries = getAllCountries();
		Optional<Country> country = countries.stream().filter(c -> c.getName().equals(name)).findFirst();
		return country;
	}
}
