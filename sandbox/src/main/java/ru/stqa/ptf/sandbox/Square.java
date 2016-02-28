package ru.stqa.ptf.sandbox;

/**
 * Created by neznaa on 2/25/2016.
 */
public class Square {

  public double l;

  public Square(double l) {
    this.l = l;
  }

  public double area () {
    return this.l * this.l;
  }
}