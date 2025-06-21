package com.maveric.systems.model;

import java.util.HashSet;
import java.util.Set;

public class OceanGrid {
	private int width, height;
	private Set<Point> obstacles = new HashSet<>();

	public OceanGrid(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void addObstacle(Point p) {
		obstacles.add(p);
	}

	public boolean isInside(Point p) {
		return p.getX() >= 0 && p.getY() >= 0 && p.getX() < width && p.getY() < height;
	}

	public boolean isBlocked(Point p) {
		return obstacles.contains(p);
	}
}
