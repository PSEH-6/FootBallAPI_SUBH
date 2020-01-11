package com.sapient.example.model;

public class FootballApi {

	private final String url;
	private final String apiKey;

	public FootballApi(String url, String apiKey) {
		this.url = url;
		this.apiKey = apiKey;
	}

	public String getUrl() {
		return url;
	}

	public String getApiKey() {
		return apiKey;
	}

}
