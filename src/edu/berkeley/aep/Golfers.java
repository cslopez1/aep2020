package edu.berkeley.aep;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Understands combining groups of golfers into efficient groups of 4.
public class Golfers {

    private final List<Integer> golfers;

    public Golfers(Integer[] golfers) {
        this.golfers = new ArrayList<>(Arrays.asList(golfers));
        for (Integer golfer : golfers) {
            if (golfer > 4) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int makeFair() {
        int teegroups = 0;
        while (golfers.size() > 0) {
            int size = 0;
            teegroups++;
            Iterator<Integer> iterator = golfers.iterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (size + next < 5) {
                    size += next;
                    iterator.remove();
                }
            }
        }
        return teegroups;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Golfers)) return false;
        return this.golfers.equals(((Golfers) other).golfers);
    }
}
