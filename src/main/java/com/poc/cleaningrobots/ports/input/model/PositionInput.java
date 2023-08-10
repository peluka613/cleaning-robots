package com.poc.cleaningrobots.ports.input.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PositionInput {
    private int x;
    private int y;
    private String direction;
}