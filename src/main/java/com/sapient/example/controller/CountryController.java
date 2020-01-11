package com.sapient.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonSyntaxException;
import com.sapient.example.model.Country;
import com.sapient.example.model.ResponseWrapper;
import com.sapient.example.service.CountryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "CountryController" }, description = "REST endpoints to get country data.")
@SwaggerDefinition(tags = { @Tag(name = "CountryController", description = "REST endpoints to get country data.") })
@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@ApiOperation(value = "Fetch all Countries.", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns all countries."),
			@ApiResponse(code = 204, message = "Could not fetch countries."),
	})
	@GetMapping(value = "/")
	public ResponseEntity<ResponseWrapper> getCountries() {
		try {
			List<Country> countries = countryService.getAllCountries();
			return ResponseEntity.ok(ResponseWrapper.success(countries));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Could not fetch countries. Error: " + ex.getMessage()));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}

	@ApiOperation(value = "Fetch Country by id.", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns Country for given country id."),
			@ApiResponse(code = 204, message = "Country not found for id."),
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseWrapper> getCountry(@PathVariable("id") int id) {
		try {
			Optional<Country> response = countryService.getCountry(id);
			if (!response.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseWrapper.error("Country not found for id: " + id));
			}
			return ResponseEntity.ok(ResponseWrapper.success(response.get()));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Country not found for id: " + id));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}
}
