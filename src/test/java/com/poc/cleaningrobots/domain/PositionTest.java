package com.poc.cleaningrobots.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    Position position;

    @BeforeEach
    void setUp() {
        position = new Position(2, 2, Direction.N);
    }

    @Test
    void moveForward() {
        assertEquals(2, position.getX());
        assertEquals(2, position.getY());
        position.moveForward();
        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
    }

    @Test
    void turnLeft() {
        assertEquals(Direction.N, position.getDirection());
        position.turnLeft();
        assertEquals(Direction.W, position.getDirection());
    }

    @Test
    void turnRight() {
        assertEquals(Direction.N, position.getDirection());
        position.turnRight();
        assertEquals(Direction.E, position.getDirection());
    }
}