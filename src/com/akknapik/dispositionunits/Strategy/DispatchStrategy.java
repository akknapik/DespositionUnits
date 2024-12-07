package com.akknapik.dispositionunits.Strategy;

import com.akknapik.dispositionunits.Unit;

public abstract class DispatchStrategy {
    private static Unit unit;
    private static int numberOfFireTrucksDispatched;

    public abstract DispatchStrategy dispositionUnits();
}
