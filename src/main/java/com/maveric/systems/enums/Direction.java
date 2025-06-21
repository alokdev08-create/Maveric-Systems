package com.maveric.systems.enums;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

    public Direction left() {
        return values()[(ordinal() + 3) % 4];
    }

    public Direction right() {
        return values()[(ordinal() + 1) % 4];
    }
}
