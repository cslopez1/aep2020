package edu.berkeley.aep;

import javafx.util.Pair;

import java.util.*;

// Understands how to traverse a graph of cities to find the shortest route
public class City {
    private List<Route> children = new ArrayList<>();
    public final static int UNREACHABLE = Integer.MAX_VALUE;

    public boolean canReach(City destination) {
        return hopsTo(destination) != UNREACHABLE;
    }

    public void addChild(Route route) {
        children.add(route);
    }

    public int hopsTo(City destination) {
        return costTo(destination, new HashSet<>(), (total, cost) -> total + 1);
    }

    public int costTo(City destination) {
        return costTo(destination, new HashSet<>(), Integer::sum);
    }

    public int costTo(City destination, Set<City> visited, Strategy strategy) {
        if (this == destination) return 0;
        if (!visited.add(this)) return UNREACHABLE;
        int champion = UNREACHABLE;
        for (Route child : children) {
            int hops = child.costTo(destination, new HashSet<>(visited), strategy);
            if (hops != UNREACHABLE && hops < champion) {
                champion = hops;
            }
        }

        return champion;
    }

//    Too many jobs for a single class, but implementation works

//    private final List<Pair> adjacent = new ArrayList<>();
//    public final static int UNREACHABLE = Integer.MAX_VALUE;
//
//    private enum Type { COUNT, COST }
//
//
//    public boolean canReach(City destination) {
//        return hopCounter(destination, new HashSet<>(), Type.COUNT) != UNREACHABLE;
//    }
//
//    public int hopsTo(City destination) {
//        return hopCounter(destination, new HashSet<>(), Type.COUNT);
//    }
//
//    public int costTo(City destination) {
//        return hopCounter(destination, new HashSet<>(), Type.COST);
//    }
//
//    private int hopCounter(City destination, Set<City> visited, Type type) {
//        if (this == destination) return 0;
//
//        if (visited.contains(this)) return UNREACHABLE;
//        visited.add(this);
//
//        int champion = UNREACHABLE;
//        for (Pair node : adjacent) {
//            City key = (City) node.getKey();
//            int hops = key.hopCounter(destination, new HashSet<>(visited), type);
//            if (hops != UNREACHABLE && hops < champion) {
//                if (type == Type.COUNT) {
//                    champion = hops + 1;
//                }
//                else if (type == Type.COST) {
//                    int value = (int) node.getValue();
//                    champion = hops + value;
//                }
//            }
//        }
//        return champion;
//    }
//
//    public void addChild(City other, int cost) {
//        Pair<City, Integer> pair = new Pair<>(other, cost);
//        adjacent.add(pair);
//    }
}
