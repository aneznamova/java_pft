package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.sandbox.Point;

/**
 * Created by neznaa on 2/28/2016.
 */
public class PointTest {
  @Test
  public void testDistanceTest1() {
    Point p1 = new Point(5,6);
    Point p2 = new Point(9,7);
    Assert.assertEquals(Point.distance(p1,p2),4.123105625617661);
  }

  @Test
  public void testDistanceTest2() {
    Point p1 = new Point(-2,-2);
    Point p2 = new Point(0,0);
    Assert.assertEquals(Point.distance(p1,p2),2.8284271247461903);
  }

  @Test
  public void testDistanceTest3() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(0,0);
    Assert.assertEquals(Point.distance(p1,p2),0.0);
  }
}
