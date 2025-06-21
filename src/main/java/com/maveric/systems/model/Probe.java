package com.maveric.systems.model;

import java.util.ArrayList;
import java.util.List;

import com.maveric.systems.enums.Direction;

public class Probe {
	private Point position;
    private Direction direction;
    private OceanGrid grid;
    private List<Point> visited = new ArrayList<>();

    public Probe(Point start, Direction direction, OceanGrid grid) {
        this.position = start;
        this.direction = direction;
        this.grid = grid;
        visited.add(start);
    }

    public void moveForward() {
        Point next = getNextPosition(1);
        moveIfAllowed(next);
    }

    public void moveBackward() {
        Point next = getNextPosition(-1);
        moveIfAllowed(next);
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    private Point getNextPosition(int step) {
        switch (direction) {
            case NORTH: return position.move(0, step);
            case SOUTH: return position.move(0, -step);
            case EAST:  return position.move(step, 0);
            case WEST:  return position.move(-step, 0);
        }
        return position;
    }

    private void moveIfAllowed(Point next) {
        if (grid.isInside(next) && !grid.isBlocked(next)) {
            position = next;
            visited.add(next);
        }
    }

    public Point getPosition() { return position; }
    public Direction getDirection() { return direction; }
    public List<Point> getVisited() { return visited; }
}
