package com.sapient.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonSyntaxException;
import com.sapient.example.model.League;
import com.sapient.example.model.ResponseWrapper;
import com.sapient.example.service.LeagueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "LeagueController" }, description = "REST endpoints to get League data.")
@SwaggerDefinition(tags = { @Tag(name = "LeagueController", description = "REST endpoints to get League data.") })
@RestController
@RequestMapping("/leagues")
public class LeagueController {

	@Autowired
	private LeagueService leagueService;

	@ApiOperation(value = "Fetch all Leagues.", response = ResponseWrapper.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns all leagues."),
			@ApiResponse(code = 204, message = "Could not fetch Leagues."),
	})
	@GetMapping(value = "/")
	public ResponseEntity<ResponseWrapper> getLeagues() {
		try {
			List<League> leagues = leagueService.getAllLeagues();
			return ResponseEntity.ok(ResponseWrapper.success(leagues));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Could not fetch Leagues. Error: " + ex.getMessage()));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}

	@ApiOperation(value = "Fetch League by Country Id.", response = ResponseWrapper.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns Leagues for given country id."),
			@ApiResponse(code = 204, message = "League not found for id."),
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseWrapper> getLeague(@PathVariable("id") int id) {
		try {
			List<League> leagues = leagueService.getLeague(id);
			return ResponseEntity.ok(ResponseWrapper.success(leagues));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("League not found for id: " + id));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}
}
