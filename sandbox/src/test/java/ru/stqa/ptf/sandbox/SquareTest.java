package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by neznaa on 2/28/2016.
 */
public class SquareTest {

  @Test
    public void testArea() {
      Square s = new Square(5);
      Assert.assertEquals(s.area(),20.0);

    }

}