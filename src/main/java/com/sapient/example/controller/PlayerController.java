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
import com.sapient.example.model.Player;
import com.sapient.example.model.ResponseWrapper;
import com.sapient.example.service.PlayerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(tags = { "PlayerController" }, description = "REST endpoints to get Player data.")
@SwaggerDefinition(tags = { @Tag(name = "PlayerController", description = "REST endpoints to get Player data.") })
@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@ApiOperation(value = "Fetch Player details by id.", response = Player.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns player by id."),
			@ApiResponse(code = 204, message = "Player not found with id."),
	})
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseWrapper> getPlayer(@PathVariable("id") int id) {

		try {
			Player player = playerService.getPlayer(id);
			return ResponseEntity.ok(ResponseWrapper.success(player));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Player not found with id: " + id));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}

	@ApiOperation(value = "Fetch Players by name.", response = Player.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns players by name."),
			@ApiResponse(code = 204, message = "Players not found with name."),
	})
	@GetMapping(value = "/")
	public ResponseEntity<ResponseWrapper> getPlayer(@RequestParam String name) {
		try {
			List<Player> players = playerService.getPlayer(name);
			return ResponseEntity.ok(ResponseWrapper.success(players));
		} catch (JsonSyntaxException ex) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ResponseWrapper.error("Player not found with name: " + name));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.error(ex.getMessage()));
		}
	}
}
