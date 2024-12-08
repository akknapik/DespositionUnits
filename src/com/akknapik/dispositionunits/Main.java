package com.akknapik.dispositionunits;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SKKM skkm = new SKKM();

        skkm.registerObserver(Unit.createAllUnits());

        Random random = new Random();
        while(true) {
            String nameOfIncident = random.nextDouble() < 0.3 ? "Pożar" : "Miejscowe zagrożenie";
            Position position = new Position(50.05 + random.nextDouble() * 0.1, 19.93 + random.nextDouble() * 0.1);
            //Position position = new Position(50.14902631605296, 20.01143191694563);
            boolean falseAlarm = random.nextDouble() < 0.05;
            Incident incident = new Incident(nameOfIncident, position, falseAlarm);
            skkm.handleIncident(incident);

            long nextIncidentTime = (2000 + (long) (Math.random() * 8000));
            try {
                Thread.sleep(nextIncidentTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
