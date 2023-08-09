package com.poc.cleaningrobots.exceptions;

public class InvalidInstructionException extends RuntimeException {
    public InvalidInstructionException(String instruction) {
        super(String.format("The instruction '%s' is not valid", instruction));
    }
}
