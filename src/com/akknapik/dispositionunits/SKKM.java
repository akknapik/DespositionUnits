package com.akknapik.dispositionunits;

import com.akknapik.dispositionunits.Strategy.Distance;

import java.util.ArrayList;
import java.util.List;

public class SKKM {
    private List<Unit> allUnits;
    private static final Object lock = new Object();

    public SKKM() {
    }

    public void registerObserver(List<Unit> units) {
        this.allUnits = units;
    }

    public void handleIncident(Incident incident) {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        System.out.println("Nowe zdarzenie: " + incident.getNameOfIncident() + ", lokalizacja: " + incident.getPosition().toString());
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        Distance distance = new Distance(allUnits, incident.getPosition());
        int requiredTrucks = incident.getStrategy().requiredTrucks();
        List<FireTruck> dispatchedTrucks = new ArrayList<>();

        synchronized (lock) {
            while (dispatchedTrucks.size() < requiredTrucks) {
                dispatchedTrucks.clear();
                for (Unit unit : distance.getSortedUnitsIterator()) {
                    List<FireTruck> availableTrucks = unit.getAvailableTrucks();
                    for (FireTruck fireTruck : availableTrucks) {
                        dispatchedTrucks.add(fireTruck);
                        if (dispatchedTrucks.size() == requiredTrucks) {
                            break;
                        }
                    }
                    if (dispatchedTrucks.size() == requiredTrucks) {
                        break;
                    }
                }

                if (dispatchedTrucks.size() < requiredTrucks) {
                    System.out.println("Nie wystarczająca liczba jednostek, oczekiwanie na dostępne wozy...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            for (FireTruck fireTruck : dispatchedTrucks) {
                fireTruck.dispatch(incident);
            }
        }
    }

    public static Object getLock() {
        return lock;
    }
}
