package com.akknapik.dispositionunits;

import com.akknapik.dispositionunits.Strategy.DispatchStrategy;
import com.akknapik.dispositionunits.Strategy.FireStrategy;
import com.akknapik.dispositionunits.Strategy.LocalThreatStrategy;

import java.util.Random;

public class Incident {
    private final String nameOfIncident;
    private final Position position;
    private final DispatchStrategy strategy;
    private final boolean falseAlarm;
    private final long timeToArrive;
    private final long actionTime;
    private final long timeToReturn;
    private boolean falseAlarmLogged = false;

    public Incident() {
        this.nameOfIncident = new Random().nextDouble() < 0.3 ? "Pożar" : "Miejscowe zagrożenie";
        this.position = new Position(50.05 + new Random().nextDouble() * 0.1, 19.93 + new Random().nextDouble() * 0.1);
        this.falseAlarm = new Random().nextDouble() < 0.05;
        this.strategy = nameOfIncident.equals("Pożar") ? new FireStrategy() : new LocalThreatStrategy();
        this.timeToArrive = (long) (Math.random() * 3000);
        this.actionTime = this.falseAlarm ? 0 : (5000 + (long) (Math.random() * 20000));
        this.timeToReturn = this.timeToArrive;
    }


    public Incident(String nameOfIncident, Position position, boolean falseAlarm) {
        this.nameOfIncident = nameOfIncident;
        this.position = position;
        this.strategy = nameOfIncident.equals("Pożar") ? new FireStrategy() : new LocalThreatStrategy();
        this.falseAlarm = falseAlarm;
        this.timeToArrive = (long) (Math.random() * 3000);
        this.actionTime = this.falseAlarm ? 0 : (5000 + (long) (Math.random() * 20000));
        this.timeToReturn = this.timeToArrive;
    }

    public synchronized void logFalseAlarm() {
        if (!falseAlarmLogged) {
            System.out.println(
                    "***************************************************************************************************************************************");
            System.out.println("Zdarzenie: " + nameOfIncident + ", lokalizacja: " + position + " to alarm fałszywy. Powrót samochodów do jednostek.");
            System.out.println(
                    "***************************************************************************************************************************************");
            falseAlarmLogged = true;
        }
    }

    public boolean isFalseAlarm() {
        return falseAlarm;
    }

    public Position getPosition() {
        return position;
    }

    public DispatchStrategy getStrategy() {
        return strategy;
    }

    public String getNameOfIncident() {
        return nameOfIncident;
    }

    public long getTimeToArrive() {
        return timeToArrive;
    }

    public long getActionTime() {
        return actionTime;
    }

    public long getTimeToReturn() {
        return timeToReturn;
    }
}
