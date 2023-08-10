package com.poc.cleaningrobots.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Floor {
    private int maxX;
    private int maxY;
    List<Robot> robots;
}
