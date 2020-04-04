package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GolfersTest {
    @Test
    public void oneGroupShouldReturnOne() {
        Golfers golfers = new Golfers(new Integer[]{4});
        int expected = 1;
        assertEquals(golfers.makeFair(), expected);
    }

    @Test
    public void twoIdenticalGolfersShouldBeEqual() {
        Golfers golfers = new Golfers(new Integer[]{1, 2});
        Golfers expected = new Golfers(new Integer[]{1, 2});
        assertEquals(golfers, expected);
    }

    @Test
    public void twoDifferentGolfersShouldNotBeEqual() {
        Golfers golfers = new Golfers(new Integer[]{1, 2});
        Golfers expected = new Golfers(new Integer[]{1, 3});
        assertNotEquals(golfers, expected);
    }

    @Test
    public void oneGolferFollowedByTwoGolfersShouldReturnOne() {
        Golfers golfers = new Golfers(new Integer[]{1, 2});
        int expected = 1;
        assertEquals(golfers.makeFair(), expected);
    }

    @Test
    public void oneAndThreeShouldEqualTwoAndTwo() {
        Golfers golfers = new Golfers(new Integer[]{1, 3});
        Golfers expected = new Golfers(new Integer[]{2, 2});
        assertEquals(golfers.makeFair(), expected.makeFair());
    }

    @Test
    public void twoThreeTwoOneShouldEqualTwo() {
        Golfers golfers = new Golfers(new Integer[]{2, 3, 2, 1});
        int expected = 2;
        assertEquals(golfers.makeFair(), expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void greaterThanForShouldThrowException() {
        Golfers golfers = new Golfers(new Integer[]{2, 5, 2, 1});
    }

    @Test
    public void twoTwoTwoOneShouldEqualTwo() {
        Golfers golfers = new Golfers(new Integer[]{2, 2, 2, 1});
        int expected = 2;
        assertEquals(golfers.makeFair(), expected);
    }

    @Test
    public void twoTwoTwoOneThreeShouldEqualThree() {
        Golfers golfers = new Golfers(new Integer[]{2, 2, 2, 1, 3});
        int expected = 3;
        assertEquals(golfers.makeFair(), expected);
    }

    @Test
    public void twoTwoTwoThreeOneShouldEqualThree() {
        Golfers golfers = new Golfers(new Integer[]{2, 2, 2, 3, 1});
        int expected = 3;
        assertEquals(golfers.makeFair(), expected);
    }
}
