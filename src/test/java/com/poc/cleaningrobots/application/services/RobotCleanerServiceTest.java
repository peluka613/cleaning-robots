package com.poc.cleaningrobots.application.services;

import com.poc.cleaningrobots.domain.Direction;
import com.poc.cleaningrobots.domain.Floor;
import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.domain.Robot;
import com.poc.cleaningrobots.exceptions.EmptyInstructionException;
import com.poc.cleaningrobots.exceptions.FloorOverflowException;
import com.poc.cleaningrobots.exceptions.InvalidInstructionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotCleanerServiceTest {

    private Floor floor;
    private RobotCleanerService service;

    @BeforeEach
    void setUp() {
        List<Robot> robots = new ArrayList<>();

        Position initialPosition = new Position(1, 2, Direction.N);
        robots.add(new Robot(initialPosition, "LMLMLMLMM"));

        initialPosition = new Position(3, 3, Direction.E);
        robots.add(new Robot(initialPosition, "MMRMMRMRRM"));

        floor = new Floor(5, 5, robots);

        service = new RobotCleanerServiceImpl();
    }

    @Test
    void perform() {
        assertEquals(5, floor.getMaxX());
        assertEquals(5, floor.getMaxY());
        assertEquals(2, floor.getRobots().size());

        List<Position> results = service.perform(floor);

        assertEquals(1, results.get(0).getX());
        assertEquals(3, results.get(0).getY());
        assertEquals(Direction.N, results.get(0).getDirection());

        assertEquals(5, results.get(1).getX());
        assertEquals(1, results.get(1).getY());
        assertEquals(Direction.E, results.get(1).getDirection());
    }

    @Test()
    void invalidInstructions() {
        floor.getRobots().clear();
        Position initialPosition = new Position(0, 0, Direction.N);
        String instructions = "RMX";

        floor.getRobots().add(new Robot(initialPosition, instructions));
        assertThrows(InvalidInstructionException.class, () -> service.perform(floor));
    }

    @Test()
    void emptyInstructions() {
        floor.getRobots().clear();
        Position initialPosition = new Position(0, 0, Direction.N);
        String instructions = "";
        floor.getRobots().add(new Robot(initialPosition, instructions));
        assertThrows(EmptyInstructionException.class, () -> service.perform(floor));
    }

    @Test()
    void overflowTheFloorArea() {
        floor.getRobots().clear();
        Position initialPosition = new Position(3, 3, Direction.N);
        String instructions = "MMMMM";
        floor.getRobots().add(new Robot(initialPosition, instructions));
        assertThrows(FloorOverflowException.class, () -> service.perform(floor));
    }
}