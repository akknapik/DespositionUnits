package com.akknapik.dispositionunits.State;

import com.akknapik.dispositionunits.FireTruck;
import com.akknapik.dispositionunits.Incident;

public class InUnitState implements  IState {
    private final FireTruck fireTruck;

    public InUnitState(FireTruck fireTruck) {
        this.fireTruck = fireTruck;
    }

    @Override
    public void dispatch(Incident incident) {
        System.out.println("#SKKM: Dysponuje wóz strażacki: " + fireTruck.getName());
        fireTruck.setState(new OutUnitState(fireTruck));

        new Thread(() -> {
            try {
                Thread.sleep(incident.getTimeToArrive());
                if(!incident.isFalseAlarm()) {
                    Thread.sleep(incident.getActionTime());
                }
                else {
                    incident.logFalseAlarm();
                }
                Thread.sleep(incident.getTimeToReturn());
                fireTruck.returnToUnit();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
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
