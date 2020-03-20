package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuantityTest {

    @Test
    public void twelveInchesShouldEqualOneFoot() {
        Quantity twelveInches = new Quantity(12, Unit.INCHES);
        Quantity oneFoot = new Quantity(1, Unit.FEET);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        Quantity twelveInches = new Quantity(3, Unit.FEET);
        Quantity oneFoot = new Quantity(1, Unit.YARD);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void oneThousandSevenHundredAndSixtyYardsShouldEqualOneMile() {
        Quantity oneK760Yards = new Quantity(1760, Unit.YARD);
        Quantity oneMile = new Quantity(1, Unit.MILE);
        assertEquals(oneK760Yards, oneMile);
    }

    @Test
    public void oneTbspShouldEqualThreeTsp() {
        Quantity oneTbsp = new Quantity(1, Unit.TBSP);
        Quantity threeTsp = new Quantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void twoTbspShouldEqualOneOz() {
        Quantity twoTbsp = new Quantity(2, Unit.TBSP);
        Quantity oneOz = new Quantity(1, Unit.OZ);
        assertEquals(twoTbsp, oneOz);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        Quantity twoTbsp = new Quantity(8, Unit.OZ);
        Quantity oneOz = new Quantity(1, Unit.CUP);
        assertEquals(twoTbsp, oneOz);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        Quantity twoInches = new Quantity(2, Unit.INCHES);
        assertEquals(new Quantity(4, Unit.INCHES), twoInches.add(twoInches));
    }

    @Test
    public void twoTablespoonsPlusOneOzShouldEqualTwelveTeaspoons() {
        Quantity twoTbsp = new Quantity(2, Unit.TBSP);
        Quantity oneOz = new Quantity(1, Unit.OZ);
        assertEquals(new Quantity(12, Unit.TSP), twoTbsp.add(oneOz));
    }

    @Test
    public void twoHundredAndTwelveFahrenheitShouldEqualOneHundredCelsius() {
        Quantity twoHundredTwelveFahrenheit = new Quantity(212, Unit.FAHRENHEIT);
        Quantity oneHundredCelsius = new Quantity(100, Unit.CELSIUS);
        assertEquals(twoHundredTwelveFahrenheit, oneHundredCelsius);
    }

    @Test
    public void thirtyTwoFahrenheitShouldEqualZeroCelsius() {
        Quantity thirtyTwoFahrenheit = new Quantity(32, Unit.FAHRENHEIT);
        Quantity zeroCelsius = new Quantity(0, Unit.CELSIUS);
        assertEquals(zeroCelsius, thirtyTwoFahrenheit);
    }
}
