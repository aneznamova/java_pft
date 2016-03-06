package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by neznaa on 3/6/2016.
 */
public class EquationTest {

    @Test
    public void Test0() {
        Equation e = new Equation(1,1,1);
        Assert.assertEquals(e.rootNumber(),0);
    }

    @Test
    public void Test1() {
        Equation e = new Equation(1,2,1);
        Assert.assertEquals(e.rootNumber(),1);
    }

    @Test
    public void Test2() {
        Equation e = new Equation(1,5,6);
        Assert.assertEquals(e.rootNumber(),2);
    }

}
