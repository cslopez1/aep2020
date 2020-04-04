package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseTest {
    @Test
    public void aReversedShouldEqualA() {
        Reverser toReverse = new Reverser("a");
        Reverser reversed = new Reverser(toReverse.reverse());
        Reverser reverseString = new Reverser("a");
        assertEquals(reversed, reverseString);
    }

    @Test
    public void asReversedShouldEqualSa() {
        Reverser toReverse = new Reverser("as");
        Reverser reversed = new Reverser(toReverse.reverse());
        Reverser reverseString = new Reverser("sa");
        assertEquals(reversed, reverseString);
    }

    @Test
    public void bananaReversedShouldEqualAnanab() {
        Reverser toReverse = new Reverser("pumpkin");
        Reverser reversed = new Reverser(toReverse.reverse());
        Reverser reverseString = new Reverser("nikpmup");
        assertEquals(reversed, reverseString);
    }
}
