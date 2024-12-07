package com.akknapik.dispositionunits.Strategy;

public class LocalThreatStrategy implements DispatchStrategy {

    @Override
    public int requiredTrucks() {
        return 2;
    }
}
