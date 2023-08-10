package com.poc.cleaningrobots.ports.output.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PositionOutput {
    private int x;
    private int y;
    private String direction;
}