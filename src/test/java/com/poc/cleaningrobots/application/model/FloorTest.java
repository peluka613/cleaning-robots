package com.poc.cleaningrobots.application.model;

import com.poc.cleaningrobots.domain.Direction;
import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.domain.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    private Floor floor;

    @BeforeEach
    void setUp() {
        List<Robot> robots = new ArrayList<>();

        Position initialPosition = new Position(1, 2, Direction.N);
        robots.add(new Robot(initialPosition, "LMLMLMLMM"));

        initialPosition = new Position(3, 3, Direction.E);
        robots.add(new Robot(initialPosition, "MMRMMRMRRM"));

        floor = new Floor(5, 5, robots);
    }

    @Test
    void perform() {
        assertEquals(5, floor.getMaxX());
        assertEquals(5, floor.getMaxY());
        assertEquals(2, floor.getRobots().size());

        List<Position> results = floor.perform();

        assertEquals(1, results.get(0).getX());
        assertEquals(3, results.get(0).getY());
        assertEquals(Direction.N, results.get(0).getDirection());

        assertEquals(5, results.get(1).getX());
        assertEquals(1, results.get(1).getY());
        assertEquals(Direction.E, results.get(1).getDirection());
    }
}