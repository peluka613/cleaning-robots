package com.poc.cleaningrobots.application.model;

import com.poc.cleaningrobots.domain.Position;
import com.poc.cleaningrobots.domain.Robot;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class Floor {
    private int maxX;
    private int maxY;
    List<Robot> robots;

    public List<Position> perform() {
        return robots.stream().map(
                robot -> {
                    robot.start();
                    return robot.getPosition();
                }).collect(Collectors.toList());
    }
}
