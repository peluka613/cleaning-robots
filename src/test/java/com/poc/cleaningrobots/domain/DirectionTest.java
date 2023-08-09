package com.poc.cleaningrobots.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void values() {
        assertEquals(4, Direction.values().length);
    }
}