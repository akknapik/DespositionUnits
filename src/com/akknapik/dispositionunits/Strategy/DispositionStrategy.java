package com.akknapik.dispositionunits.Strategy;

import com.akknapik.dispositionunits.Unit;

public abstract class DispositionStrategy {
    private static Unit unit;
    private static int numberOfFireTrucksDispatched;

    public abstract DispositionStrategy dispositionUnits();
}
