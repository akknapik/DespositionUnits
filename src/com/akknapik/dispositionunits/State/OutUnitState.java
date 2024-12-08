package com.akknapik.dispositionunits.State;

import com.akknapik.dispositionunits.FireTruck;
import com.akknapik.dispositionunits.Incident;
import com.akknapik.dispositionunits.SKKM;

public class OutUnitState implements IState{
    private FireTruck fireTruck;

    public OutUnitState(FireTruck fireTruck) {
        this.fireTruck = fireTruck;
    }

    @Override
    public void dispatch(Incident incident) {
        System.out.println("Wóz strażacki " + fireTruck.getName() + " jest obecnie na akcji.");
    }

    @Override
    public void returnToUnit() {
        System.out.println("Wóz strażacki " + fireTruck.getName() + " powrócił do jednostki.");
        fireTruck.setState(new InUnitState(fireTruck));

        synchronized (SKKM.getLock()) {
            SKKM.getLock().notifyAll();
        }
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
