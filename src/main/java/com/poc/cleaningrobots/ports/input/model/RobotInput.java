package com.poc.cleaningrobots.ports.input.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RobotInput {
    private String position;
    private String instructions;
}
