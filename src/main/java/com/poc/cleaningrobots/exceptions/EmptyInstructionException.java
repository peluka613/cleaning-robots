package com.poc.cleaningrobots.exceptions;

public class EmptyInstructionException extends RuntimeException {
    public EmptyInstructionException() {
        super("The instruction cannot be empty");
    }
}
