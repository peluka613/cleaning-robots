package com.poc.cleaningrobots.adapter.input.web;

import com.poc.cleaningrobots.application.services.RobotCleanerService;
import com.poc.cleaningrobots.domain.Floor;
import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.exceptions.EmptyInstructionException;
import com.poc.cleaningrobots.exceptions.FloorOverflowException;
import com.poc.cleaningrobots.exceptions.InvalidInstructionException;
import com.poc.cleaningrobots.ports.input.model.FloorInput;
import com.poc.cleaningrobots.ports.input.web.WebInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class WebController implements WebInputPort {

    @Autowired
    private RobotCleanerService service;

//    @Autowired
//    public WebController(RobotCleanerService service) {
//        this.service = service;
//    }

    @Override
    public ResponseEntity<String> process(FloorInput input) {
        Floor floor = mapInputToFloor(input);
        try {
            List<Position> results = service.perform(floor);
            results.forEach(position -> log.debug("{} {} {}", position.getX(), position.getY(), position.getDirection().name()));

            return ResponseEntity.ok("Request processing");
        } catch (EmptyInstructionException | InvalidInstructionException | FloorOverflowException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    private Floor mapInputToFloor(FloorInput input) {
        return new Floor(input.getMaxX(), input.getMaxY(), new ArrayList<>());
    }
}
