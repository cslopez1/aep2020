package edu.berkeley.aep;

import java.util.*;

// Understands if a path can be created between two city nodes in a directed graph.
public class City {

    private final List<City> adjacent = new ArrayList<>();
    public final static int UNREACHABLE = -1;


    public boolean canReach(City destination) {
        return hopCounter(destination, new HashSet<>()) != UNREACHABLE;
    }

    public int hopsTo(City destination) {
        return hopCounter(destination, new HashSet<>());
    }

    private int hopCounter(City destination, Set<City> visited) {
        if (this == destination) return 0;

        if (visited.contains(this)) return UNREACHABLE;
        visited.add(this);

        for (City node : adjacent) {
            int hops = node.hopCounter(destination, visited);
            if (hops != UNREACHABLE) return hops + 1;
        }
        return UNREACHABLE;
    }

    public void addChild(City other) {
        adjacent.add(other);
    }
}
