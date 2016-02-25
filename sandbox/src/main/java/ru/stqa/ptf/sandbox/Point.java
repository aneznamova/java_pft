package ru.stqa.ptf.sandbox;

/**
 * Created by neznaa on 2/25/2016.
 */
public class Point {

  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point() {

  }

  public double distance(Point p1, Point p2) {
    double x = p1.x - p2.x;
    double y = p1.y - p2.y;
    return Math.sqrt(x * x + y * y);
  }
}
