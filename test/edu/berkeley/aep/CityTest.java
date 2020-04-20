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
        cityH.addChild(new Route(cityB, 600));
        cityA.addChild(new Route(cityF, 100));
        cityB.addChild(new Route(cityA, 200));
        cityB.addChild(new Route(cityC, 50));
        cityC.addChild(new Route(cityE, 400));
        cityC.addChild(new Route(cityE, 200));
        cityC.addChild(new Route(cityD, 50));
        cityD.addChild(new Route(cityE, 100));
        cityE.addChild(new Route(cityB, 500));

//        cityH.addChild(cityB, 600);
//        cityA.addChild(cityF, 100);
//        cityB.addChild(cityA, 200);
//        cityB.addChild(cityC, 50);
//        cityC.addChild(cityE, 400);
//        cityC.addChild(cityE, 200);
//        cityC.addChild(cityD, 50);
//        cityD.addChild(cityE, 100);
//        cityE.addChild(cityB, 500);
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
    public void hToGShouldReturnNegative1() {
        assertEquals(City.UNREACHABLE, cityH.hopsTo(cityG));
    }

    @Test
    public void hToCShouldReturn2() {
        assertEquals(2, cityH.hopsTo(cityC));
    }

    @Test
    public void hToHShouldReturn0() {
        assertEquals(0, cityH.hopsTo(cityH));
    }

    @Test
    public void bToEShouldReturn2() {
        assertEquals(2, cityB.hopsTo(cityE));
    }

    @Test
    public void cToBShouldReturn2() {
        assertEquals(2, cityC.hopsTo(cityB));
    }

    @Test
    public void bToECostShouldReturn200() {
        assertEquals(200, cityB.costTo(cityE));
    }

    @Test
    public void CToBCostShouldReturn650() {
        assertEquals(650, cityC.costTo(cityB));
    }

//    @Test
//    public void hToHCostShouldReturn0() {
//        assertEquals(0, cityH.costTo(cityH));
//    }
//
//    @Test
//    public void hToFCostShouldReturn900() {
//        assertEquals(900, cityH.costTo(cityF));
//    }
//
//    @Test
//    public void bToECostShouldReturn200() {
//        assertEquals(200, cityB.costTo(cityE));
//    }
//
//    @Test
//    public void CToBCostShouldReturn650() {
//        assertEquals(650, cityC.costTo(cityB));
//    }
}
