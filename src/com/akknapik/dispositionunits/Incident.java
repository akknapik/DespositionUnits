package com.akknapik.dispositionunits;

import com.akknapik.dispositionunits.Strategy.DispatchStrategy;
import com.akknapik.dispositionunits.Strategy.FireStrategy;
import com.akknapik.dispositionunits.Strategy.LocalThreatStrategy;

public class Incident {
    private String nameOfIncident;
    private Position position;
    private DispatchStrategy strategy;
    private boolean falseAlarm;

    public Incident(String nameOfIncident, Position position, DispatchStrategy strategy, boolean falseAlarm) {
        this.nameOfIncident = nameOfIncident;
        this.position = position;
        this.strategy = nameOfIncident.equals("Pożar") ? new FireStrategy() : new LocalThreatStrategy();
        this.falseAlarm = falseAlarm;
    }

    public boolean isFalseAlarm() {
        return falseAlarm;
    }
}
