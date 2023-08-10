package com.poc.cleaningrobots.application.services;

import com.poc.cleaningrobots.domain.Floor;
import com.poc.cleaningrobots.domain.Instruction;
import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.domain.Robot;
import com.poc.cleaningrobots.exceptions.EmptyInstructionException;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RobotCleanerServiceImpl implements RobotCleanerService {


    public List<Position> perform(Floor floor) {
        return floor.getRobots().stream().map(
                robot -> {
                    start(robot);
                    return robot.getPosition();
                }).collect(Collectors.toList());
    }
    private void start(Robot robot) {
        validateEmptyInstructions(robot.getInstructions());
        performInstructions(robot);
    }

    private void validateEmptyInstructions(String instructions) {
        if (!StringUtils.hasLength(instructions)) {
            throw new EmptyInstructionException();
        }
    }

    private void performInstructions(Robot robot) {
        String instructions = robot.getInstructions();
        for (int i = 0; i < instructions.length(); i++) {
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
}
