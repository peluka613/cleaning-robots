package com.poc.cleaningrobots.exceptions;

public abstract class CleaningRobotsException extends RuntimeException {
    protected CleaningRobotsException(String message) {
        super(message);
    }
}
