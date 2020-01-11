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
import com.sapient.example.model.ResponseWrapper;
import com.sapient.example.model.Standing;
import com.sapient.example.service.StandingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "StandingController" }, description = "REST endpoints to get Standing data.")
@SwaggerDefinition(tags = { @Tag(name = "StandingController", description = "REST endpoints to get Standing data.") })
@RestController
@RequestMapping("/standings")
public class StandingController {

	@Autowired
	private StandingService standingService;

	@ApiOperation(value = "Fetch Standing details by league id.", response = ResponseWrapper.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns Standings for league id."),
			@ApiResponse(code = 204, message = "Standings not found for league id."),
	})
	@GetMapping(value = "/{leagueId}")
	public ResponseEntity<ResponseWrapper> getStandings(@PathVariable("leagueId") int leagueId) {
		try {
			List<Standing> standings = standingService.getStandings(leagueId);
			return ResponseEntity.ok(ResponseWrapper.success(standings));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Standings not found for league id: " + leagueId));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}
}
