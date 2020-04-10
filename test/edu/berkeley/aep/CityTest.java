package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    private City cityC = new City();
    private City cityF = new City();
    private City cityA = new City();
    private City cityB = new City();
    private City cityE = new City();
    private City cityD = new City();
    private City cityG = new City();
    private City cityH = new City();

    public CityTest() {
        cityH.addChild(cityB);
        cityA.addChild(cityF);
        cityB.addChild(cityA);
        cityB.addChild(cityC);
        cityC.addChild(cityE);
        cityC.addChild(cityE);
        cityC.addChild(cityD);
        cityD.addChild(cityE);
        cityE.addChild(cityB);
    }

    @Test
    public void anAdjacentCityShouldReturnTrue() {
        assertTrue(cityH.canReach(cityB));
    }

    @Test
    public void hToHShouldReturnTrue() {
        assertTrue(cityH.canReach(cityH));
    }

    @Test
    public void hToFShouldReturnTrue() {
        assertTrue(cityH.canReach(cityF));
    }

    @Test
    public void hToDShouldReturnTrue() {
        assertTrue(cityH.canReach(cityD));
    }

    @Test
    public void hToEShouldReturnTrue() {
        assertTrue(cityH.canReach(cityE));
    }

    @Test
    public void hToGShouldReturnFalse() {
        assertFalse(cityH.canReach(cityG));
    }

    @Test
    public void hToFShouldReturn3() {
        assertEquals(3, cityH.hopsTo(cityF));
    }

    @Test
    public void hToDShouldReturn3() {
        assertEquals(3, cityH.hopsTo(cityD));
    }

    @Test
    public void hToEShouldReturn3() {
        assertEquals(3, cityH.hopsTo(cityE));
    }

    @Test
    public void hToGShouldReturnNegative1() {
        assertEquals(-1, cityH.hopsTo(cityG));
    }

    @Test
    public void hToCShouldReturn2() {
        assertEquals(2, cityH.hopsTo(cityC));
    }

    @Test
    public void hToHShouldReturn0() {
        assertEquals(0, cityH.hopsTo(cityH));
    }
}
