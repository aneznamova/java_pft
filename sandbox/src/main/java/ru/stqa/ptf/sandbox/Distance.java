package ru.stqa.ptf.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Distance {

  public static void main(String[] args) {

    Point p = new Point();
    Point p1 = new Point(3, 3);
    Point p2 = new Point(6, 6);

    System.out.println("Точка p1 = (" + p1.x + " , " + p1.y + ")");
    System.out.println("Точка p2 = (" + p2.x + " , " + p2.y + ")");
    System.out.println("Расстояние между точками р1 и р2 =" + p.distance(p1, p2));
  }

}