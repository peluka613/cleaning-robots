package com.poc.cleaningrobots.exceptions;

public class EmptyRobotsException extends CleaningRobotsException {
    public EmptyRobotsException() {
        super("The robots list cannot be empty");
    }
}
