package edu.berkeley.aep;

import java.util.HashSet;

// Understands the cost between two cities.
public class Route {
    public final City to;
    private final int routeCost;

    public Route(City to, int cost) {
        this.to = to;
        this.routeCost = cost;
    }

    public int costTo(City destination, HashSet<City> visited, Strategy strategy) {
        int cost = to.costTo(destination, visited, strategy);
        if (cost == City.UNREACHABLE) return City.UNREACHABLE;
        return strategy.apply(cost, routeCost);
    }
}
