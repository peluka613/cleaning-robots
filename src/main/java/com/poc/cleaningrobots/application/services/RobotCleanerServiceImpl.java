package com.poc.cleaningrobots.application.services;

import com.poc.cleaningrobots.domain.Floor;
import com.poc.cleaningrobots.domain.Instruction;
import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.domain.Robot;
import com.poc.cleaningrobots.exceptions.EmptyInstructionException;
import com.poc.cleaningrobots.exceptions.EmptyRobotsException;
import com.poc.cleaningrobots.exceptions.FloorOverflowException;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RobotCleanerServiceImpl implements RobotCleanerService {

    public List<Position> perform(Floor floor) {
        validateRobotsList(floor);
        return floor.getRobots().stream().map(
                robot -> {
                    startRobot(floor.getMaxX(), floor.getMaxY(), robot);
                    return robot.getPosition();
                }).collect(Collectors.toList());
    }

    private void validateRobotsList(Floor floor) {
        if (floor.getRobots() == null || floor.getRobots().isEmpty()) {
            throw new EmptyRobotsException();
        }
    }

    private void startRobot(int maxX, int maxY, Robot robot) {
        validateEmptyInstructions(robot.getInstructions());
        performInstructions(maxX, maxY, robot);
    }

    private void validateEmptyInstructions(String instructions) {
        if (!StringUtils.hasLength(instructions)) {
            throw new EmptyInstructionException();
        }
    }

    private void performInstructions(int maxX, int maxY, Robot robot) {
        String instructions = robot.getInstructions();
        for (int i = 0; i < instructions.length(); i++) {
            validateFloorOverflow(maxX, maxY, robot.getPosition());
            Instruction instructionEnum = robot.getInstructionEnum(String.valueOf(instructions.charAt(i)));
            switch (instructionEnum) {
                case M:
                    robot.moveForward();
                    break;
                case L:
                    robot.turnLeft();
                    break;
                case R:
                    robot.turnRight();
                    break;
            }
        }
    }

    private void validateFloorOverflow(int maxX, int maxY, Position position) {
        if (position.getX() < 0 || position.getX() > maxX
                || position.getY() < 0 || position.getY() > maxY) {
            throw new FloorOverflowException(position.getX(), position.getY(), maxX, maxY);
        }
    }
}
