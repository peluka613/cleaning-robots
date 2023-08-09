package com.poc.cleaningrobots.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Position {
    private int x;
    private int y;
    Direction direction;

    public void moveForward() {
        x += direction.getX();
        y += direction.getY();
    }

    public void turnLeft() {
        direction = direction.getL();
    }

    public void turnRight() {
        direction = direction.getR();
    }
}
