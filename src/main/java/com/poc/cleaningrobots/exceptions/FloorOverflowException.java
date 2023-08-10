package com.poc.cleaningrobots.exceptions;

public class FloorOverflowException extends CleaningRobotsException {
    public FloorOverflowException(int x, int y, int maxX, int maxY) {
        super(String.format("The position (%s,%s) is outside the limits (0,0) to (%s,%s)", x, y, maxX, maxY));
    }
}
