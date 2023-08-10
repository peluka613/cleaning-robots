package com.poc.cleaningrobots.exceptions;

public class InvalidInstructionException extends CleaningRobotsException {
    public InvalidInstructionException(String instruction) {
        super(String.format("The instruction '%s' is not valid", instruction));
    }
}
