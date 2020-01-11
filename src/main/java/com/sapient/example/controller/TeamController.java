package com.sapient.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonSyntaxException;
import com.sapient.example.model.ResponseWrapper;
import com.sapient.example.model.Team;
import com.sapient.example.service.TeamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "TeamController" }, description = "REST endpoints to get Team data.")
@SwaggerDefinition(tags = { @Tag(name = "TeamController", description = "REST endpoints to get Team data.") })
@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@ApiOperation(value = "Fetch Team details by id.", response = ResponseWrapper.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns Team by id."),
			@ApiResponse(code = 204, message = "Team not found for id."),
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseWrapper> getTeam(@PathVariable("id") int id) {
		try {
			Team team = teamService.getTeam(id);
			return ResponseEntity.ok(ResponseWrapper.success(team));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Team not found for id: " + id));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}

	@ApiOperation(value = "Fetch Teams by leage id.", response = ResponseWrapper.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns Teams for league."),
			@ApiResponse(code = 204, message = "Teams not found for league id"),
	})
	@GetMapping(value = "/")
	public ResponseEntity<ResponseWrapper> getTeams(@RequestParam int leagueId) {
		try {
			List<Team> teams = teamService.getTeams(leagueId);
			return ResponseEntity.ok(ResponseWrapper.success(teams));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Teams not found for league id: " + leagueId));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}
}
