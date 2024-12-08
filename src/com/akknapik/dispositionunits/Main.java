package com.akknapik.dispositionunits;

public class Main {
    public static void main(String[] args) {
        SKKM skkm = new SKKM();

        for(Unit unit : Unit.createAllUnits()) {
            skkm.addObserver(unit);
        }


        while(true) {
            Incident incident = new Incident();
            skkm.notifyAll(incident);

            long nextIncidentTime = (2000 + (long) (Math.random() * 8000));
            try {
                Thread.sleep(nextIncidentTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
