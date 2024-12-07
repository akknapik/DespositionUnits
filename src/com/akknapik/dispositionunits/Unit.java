package com.akknapik.dispositionunits;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private String name;
    private Position position;
    private List<FireTruck> fireTrucks;
    private static final int numberOfFireTrucks = 5;
    private int fireTrucksInUnit;

    public Unit(String name, Position position, List<FireTruck> fireTrucks) {
        this.name = name;
        this.position = position;
        this.fireTrucks = fireTrucks;
        this.fireTrucksInUnit = numberOfFireTrucks;
    }

    public Position getPosition() {
        return position;
    }

    public static List<Unit> createAllUnits() {
        List<Unit> allUnits = new ArrayList<>();
        allUnits.add(new Unit("JRG-1", new Position( 50.0607339743158, 19.942967813073157),
                FireTruck.createFireTrucks("JRG-1_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG-2", new Position(50.03436149456929, 19.935191173276337),
                FireTruck.createFireTrucks("JRG-2_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG-3", new Position(50.07739659316156, 19.886664829344824),
                FireTruck.createFireTrucks("JRG-3_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG-4", new Position(50.038752976427325, 20.005395258351435),
                FireTruck.createFireTrucks("JRG-4_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG-5", new Position(50.09276986621814, 19.920117358782154),
                FireTruck.createFireTrucks("JRG-5_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG-6", new Position(50.0178103821736, 20.01489382434184),
                FireTruck.createFireTrucks("JRG-6_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG-7", new Position(50.095961792557276, 19.97687204929236),
                FireTruck.createFireTrucks("JRG-7_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG Szkoły Aspirantów PSP", new Position(50.07730279319274, 20.03316131577535),
                FireTruck.createFireTrucks("JRG-Szkoły-Aspirantów-PSP_", numberOfFireTrucks)));
        allUnits.add(new Unit("JRG Skawina", new Position(49.968547710318106, 19.7995243426231),
                FireTruck.createFireTrucks("JRG-Skawina_", numberOfFireTrucks)));
        allUnits.add(new Unit("LSP Lotniska w Balicach", new Position(50.0794492162288, 19.78877185854931),
                FireTruck.createFireTrucks("LSP-Lotniska-w-Balicach_", numberOfFireTrucks)));
        return allUnits;
    }

    public int getFireTrucksInUnit() {
        return fireTrucksInUnit;
    }

    public List<FireTruck> getAvailableTrucks() {
        List<FireTruck> available = new ArrayList<>();
        for (FireTruck truck : fireTrucks) {
            if (truck.isAvailable()) {
                available.add(truck);
            }
        }
        return available;
    }

    @Override
    public String toString() {
        return "Unit{" + "name='" + name + '\'' + ", position=" + position + ", fireTrucksInUnit=" + fireTrucksInUnit + '}';
    }
}
