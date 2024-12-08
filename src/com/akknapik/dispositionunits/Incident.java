package com.akknapik.dispositionunits;

import com.akknapik.dispositionunits.Strategy.DispatchStrategy;
import com.akknapik.dispositionunits.Strategy.FireStrategy;
import com.akknapik.dispositionunits.Strategy.LocalThreatStrategy;

public class Incident {
    private final String nameOfIncident;
    private final Position position;
    private final DispatchStrategy strategy;
    private final boolean falseAlarm;
    private final long timeToArrive;
    private final long actionTime;
    private final long timeToReturn;
    private boolean falseAlarmLogged = false;



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
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("Zdarzenie: " + nameOfIncident + ", lokalizacja: " + position + " to alarm fałszywy. Powrót samochodów do jednostek.");
            System.out.println(
                    "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
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
