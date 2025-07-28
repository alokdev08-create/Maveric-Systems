package com.maveric.systems.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.systems.enums.Direction;
import com.maveric.systems.model.OceanGrid;
import com.maveric.systems.model.Point;
import com.maveric.systems.model.Probe;

@RestController
@RequestMapping("/api/probe")
public class ProbeController {
	private final Probe probe;

	public ProbeController() {
		OceanGrid grid = new OceanGrid(5, 5);
		grid.addObstacle(new Point(2, 3));
		this.probe = new Probe(new Point(2, 2), Direction.NORTH, grid);
	}

	@PostMapping("/commands")
	public String control(@RequestBody String commandInput) {
		List<String> commands = Arrays.asList(commandInput.trim().split(","));

		for (String cmd : commands) {
			switch (cmd.trim().toUpperCase()) {
			case "FORWARD":
				probe.moveForward();
				break;
			case "BACKWARD":
				probe.moveBackward();
				break;
			case "LEFT":
				probe.turnLeft();
				break;
			case "RIGHT":
				probe.turnRight();
				break;
			}
		}

		return "Position: " + probe.getPosition() + " Direction: " + probe.getDirection();
	}

	@GetMapping("/visited")
	public List<Point> getVisited() {
		return probe.getVisited();
	}

	@GetMapping("/users")
	public ResponseEntity<?> getUserDetails() {
		List<String> userList = List.of("Alok", "Ranjan");
		return ResponseEntity.ok(userList);
	}
}
