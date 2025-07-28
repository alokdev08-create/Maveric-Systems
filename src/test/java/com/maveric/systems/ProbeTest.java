//package com.maveric.systems;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//
//import com.maveric.systems.enums.Direction;
//import com.maveric.systems.model.OceanGrid;
//import com.maveric.systems.model.Point;
//import com.maveric.systems.model.Probe;
//
//public class ProbeTest {
//	@Test
//	public void testProbeAvoidsObstacle() {
//		OceanGrid grid = new OceanGrid(5, 5);
//		grid.addObstacle(new Point(2, 3));
//		Probe probe = new Probe(new Point(2, 2), Direction.NORTH, grid);
//
//		probe.moveForward();
//		assertEquals(new Point(2, 2), probe.getPosition());
//	}
//
//	@Test
//	public void testTurningAndMovement() {
//		OceanGrid grid = new OceanGrid(5, 5);
//		Probe probe = new Probe(new Point(0, 0), Direction.NORTH, grid);
//
//		probe.turnRight();
//		probe.moveForward();
//
//		assertEquals(new Point(1, 0), probe.getPosition());
//		assertEquals(Direction.EAST, probe.getDirection());
//	}
//}
