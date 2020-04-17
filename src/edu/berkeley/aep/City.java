package edu.berkeley.aep;

import java.util.*;

import static java.util.Collections.min;

// Understands if a path can be created between two city nodes in a directed graph.
public class City {

    private final List<City> adjacent = new ArrayList<>();
    public final static int UNREACHABLE = Integer.MAX_VALUE;


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

        int champion = UNREACHABLE;
        for (City node : adjacent) {
            int hops = node.hopCounter(destination, new HashSet<>(visited));
            if (hops != UNREACHABLE && hops <= champion) {
                champion = hops + 1;
            }
        }
        return champion;
    }

    public void addChild(City other) {
        adjacent.add(other);
    }
}
