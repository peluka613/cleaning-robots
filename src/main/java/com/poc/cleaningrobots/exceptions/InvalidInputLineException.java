package com.poc.cleaningrobots.exceptions;

public class InvalidInputLineException extends CleaningRobotsException {
    public InvalidInputLineException() {
        super("Review all the information needed is completed and valid");
    }
}
