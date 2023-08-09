package com.poc.cleaningrobots.domain;

import com.poc.cleaningrobots.exceptions.EmptyInstructionException;
import com.poc.cleaningrobots.exceptions.InvalidInstructionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private Robot robot;
    @BeforeEach
    void setUp() {

    }

    @Test
    void start() {
        Position initialPosition = new Position(0, 0, Direction.N);
        String instructions = "RMLMMR";
        robot = new Robot(initialPosition, instructions);

        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getX());
        assertEquals(Direction.N, robot.getPosition().getDirection());

        robot.start();

        assertEquals(1, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());
        assertEquals(Direction.E, robot.getPosition().getDirection());
    }

    @Test()
    void invalidInstructions() {
        Position initialPosition = new Position(0, 0, Direction.N);
        String instructions = "RMX";
        robot = new Robot(initialPosition, instructions);
        assertThrows(InvalidInstructionException.class, () -> robot.start());
    }

    @Test()
    void emptyInstructions() {
        Position initialPosition = new Position(0, 0, Direction.N);
        String instructions = "";
        robot = new Robot(initialPosition, instructions);
        assertThrows(EmptyInstructionException.class, () -> robot.start());
    }
}