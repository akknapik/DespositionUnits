package com.akknapik.dispositionunits.State;

import com.akknapik.dispositionunits.FireTruck;

public class InUnitState implements  IState {
    private final FireTruck fireTruck;

    public InUnitState(FireTruck fireTruck) {
        this.fireTruck = fireTruck;
    }


    @Override
    public void dispatch() {
        System.out.println("Dysponuje wóz strażacki: " + fireTruck.getName());
        fireTruck.setState(new OutUnitState(fireTruck));
    }

    @Override
    public void returnToUnit() {
        System.out.println("Wóz strażacki " + fireTruck.getName() + " jest obecnie w jednostce.");
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
