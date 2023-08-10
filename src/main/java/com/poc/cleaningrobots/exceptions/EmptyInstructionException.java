package com.poc.cleaningrobots.exceptions;

public class EmptyInstructionException extends CleaningRobotsException {
    public EmptyInstructionException() {
        super("The instruction cannot be empty");
    }
}
