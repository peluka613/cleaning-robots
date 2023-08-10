package com.poc.cleaningrobots.ports.input.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class FloorInput {
    private int maxX;
    private int maxY;
    List<RobotInput> robots;
}
