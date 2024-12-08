package com.akknapik.dispositionunits;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SKKM skkm = new SKKM();

        skkm.registerObserver(Unit.createAllUnits());

        Random random = new Random();
        while(true) {
            Incident incident = new Incident();
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
