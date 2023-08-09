package com.poc.cleaningrobots.domain;

import com.poc.cleaningrobots.exceptions.EmptyInstructionException;
import com.poc.cleaningrobots.exceptions.InvalidInstructionException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Getter
public class Robot {
    private Position position;
    private String instructions;

    public void start() {
        validateEmptyInstructions();
        performInstructions();
    }

    private void validateEmptyInstructions() {
        if (!StringUtils.hasLength(instructions)) {
            throw new EmptyInstructionException();
        }
    }

    private void performInstructions() {
        for (int i = 0; i < instructions.length(); i++) {
            Instruction instructionEnum = getInstructionEnum(String.valueOf(instructions.charAt(i)));
            switch (instructionEnum) {
                case M:
                    moveForward();
                    break;
                case L:
                    turnLeft();
                    break;
                case R:
                    turnRight();
                    break;
            }
        }
    }

    private Instruction getInstructionEnum(String instruction) {
        try {
            return Instruction.valueOf(instruction);
        } catch (IllegalArgumentException e) {
            throw new InvalidInstructionException(instruction);
        }
    }

    public void moveForward() {
        position.moveForward();
    }

    public void turnLeft() {
        position.turnLeft();
    }

    public void turnRight() {
        position.turnRight();
    }

    public Position getPosition() {
        return position;
    }
}
