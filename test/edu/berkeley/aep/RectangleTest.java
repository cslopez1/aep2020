package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void rectangleWithSideOneShouldHaveAreaOne() {
        Rectangle rectangle = new Rectangle(1, 1);
        assertEquals(1, rectangle.area());
    }

    @Test
    public void rectangleWithSideTwoShouldHaveAreaFour() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(4, rectangle.area());
    }

    @Test
    public void rectangleWithSideTwoShouldHavePerimeterEight() {
        Rectangle rectangle = new Rectangle(2, 2);
        assertEquals(8, rectangle.perimeter());
    }

    @Test
    public void rectangleWithSideOneShouldHavePerimeterFour() {
        Rectangle rectangle = new Rectangle(1, 1);
        assertEquals(4, rectangle.perimeter());
    }

    @Test
    public void squareOfSideThreeShouldHaveAreaNine() {
        Rectangle square = Rectangle.createSquare(3);
        assertEquals(9, square.area());
    }
}
