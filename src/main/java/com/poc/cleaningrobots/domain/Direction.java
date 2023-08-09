package com.poc.cleaningrobots.domain;

public enum Direction {
    N(0, 1, "W", "E"),
    E(1, 0, "N", "S"),
    S(0, -1, "E", "W"),
    W(-1, 0, "S", "N");

    Direction(int x, int y, String l, String r) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.r = r;
    }

    private final int x;
    private final int y;
    private final String l;
    private final String r;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getL() {
        return valueOf(l);
    }

    public Direction getR() {
        return valueOf(r);
    }
}
