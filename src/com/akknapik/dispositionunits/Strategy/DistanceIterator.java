package com.akknapik.dispositionunits.Strategy;

import com.akknapik.dispositionunits.Unit;

import java.util.*;

public class DistanceIterator implements Iterator<Unit> {
    private final List<Unit> sortedUnits;
    private int currentIndex = 0;

    public DistanceIterator(Map<Unit, Double> sortedDistanceToUnits) {
        this.sortedUnits = List.copyOf(sortedDistanceToUnits.keySet());
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sortedUnits.size();
    }

    @Override
    public Unit next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return sortedUnits.get(currentIndex++);
    }
}
