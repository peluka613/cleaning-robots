package com.poc.cleaningrobots.adapter.input.web;

import com.poc.cleaningrobots.application.services.RobotCleanerService;
import com.poc.cleaningrobots.domain.Direction;
import com.poc.cleaningrobots.domain.Floor;
import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.domain.Robot;
import com.poc.cleaningrobots.exceptions.CleaningRobotsException;
import com.poc.cleaningrobots.exceptions.EmptyRobotsException;
import com.poc.cleaningrobots.exceptions.InvalidInputLineException;
import com.poc.cleaningrobots.ports.input.model.FloorInput;
import com.poc.cleaningrobots.ports.input.model.RobotInput;
import com.poc.cleaningrobots.ports.input.web.WebInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class WebController implements WebInputPort {

    private final RobotCleanerService service;

    public WebController(RobotCleanerService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<String> safeProcess(FloorInput input) {
        try {
            List<Position> results = process(input);
            return ResponseEntity.ok("Request processing");
        } catch (CleaningRobotsException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    private List<Position> process(FloorInput input) {
        Floor floor = mapInputToFloor(input);
        List<Position> results = service.perform(floor);
        results.forEach(position -> log.info("{} {} {}", position.getX(), position.getY(), position.getDirection().name()));
        return results;
    }

    private Floor mapInputToFloor(FloorInput input) {
        try {
            validateRobotsList(input.getRobots());
            String[] coordinates = input.getMaxSize().split(" ");
            List<Robot> robots = new ArrayList<>();
            for (RobotInput robotInput : input.getRobots()) {
                String[] positionCoordinates = robotInput.getPosition().split(" ");
                Position position = new Position(Integer.parseInt(positionCoordinates[0]), Integer.parseInt(positionCoordinates[1]), Direction.valueOf(positionCoordinates[2]));
                robots.add(new Robot(position, robotInput.getInstructions()));
            }
            return new Floor(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[0]), robots);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidInputLineException();
        }
    }

    private void validateRobotsList(List<RobotInput> robots) {
        if (robots == null || robots.isEmpty()) {
            throw new EmptyRobotsException();
        }
    }
}

