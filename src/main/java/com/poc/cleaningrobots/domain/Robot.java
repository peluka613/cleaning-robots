package com.poc.cleaningrobots.domain;

import com.poc.cleaningrobots.exceptions.InvalidInstructionException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private Position position;
    private String instructions;

    public Instruction getInstructionEnum(String instruction) {
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
