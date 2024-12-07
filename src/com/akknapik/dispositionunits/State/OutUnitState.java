package com.akknapik.dispositionunits.State;

import com.akknapik.dispositionunits.FireTruck;

public class OutUnitState implements IState{
    private FireTruck fireTruck;

    public OutUnitState(FireTruck fireTruck) {
        this.fireTruck = fireTruck;
    }

    @Override
    public void dispatch() {
        System.out.println("Wóz strażacki " + fireTruck.getName() + " jest obecnie na akcji.");
    }

    @Override
    public void returnToUnit() {
        System.out.println("Wóz strażacki " + fireTruck.getName() + " powrócił do jednostki.");
        fireTruck.setState(new InUnitState(fireTruck));
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
