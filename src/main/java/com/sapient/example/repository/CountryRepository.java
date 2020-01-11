package com.sapient.example.repository;

import java.util.List;

import com.sapient.example.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountryRepository {

	@GET("?action=get_countries")
	public Call<List<Country>> getAllCountries(@Query("APIkey") String apiKey);

}
