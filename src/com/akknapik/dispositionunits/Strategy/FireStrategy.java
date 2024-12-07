package com.akknapik.dispositionunits.Strategy;

public class FireStrategy implements DispatchStrategy {

    @Override
    public int requiredTrucks() {
        return 3;
    }
}
