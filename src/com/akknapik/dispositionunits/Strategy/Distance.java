package com.akknapik.dispositionunits.Strategy;

import com.akknapik.dispositionunits.Position;
import com.akknapik.dispositionunits.Unit;

import java.util.*;

public class Distance {
    private LinkedHashMap<Unit, Double> sortedDistanceToUnits;

    public Distance(List<Unit> units, Position threatPosition) {
        Map<Unit, Double> distanceToUnits = new HashMap<>();
        for(Unit unit : units) {
            distanceToUnits.put(unit, calculateDistance(unit, threatPosition));
        }
        this.sortedDistanceToUnits = sortByValue(distanceToUnits);
    }

    private double calculateDistance(Unit unit, Position threatPosition) {
        double lat_1 = unit.getPosition().getLatitude() * (Math.PI / 180);
        double lon_1 = unit.getPosition().getLongitude() * (Math.PI / 180);
        double alt_1 = 0;

        double lat_2 = threatPosition.getLatitude() * (Math.PI / 180);
        double lon_2 = threatPosition.getLongitude() * (Math.PI / 180);
        double alt_2 = 0;

        final double r = 6376.5 * 1000; // Radius of Earth in metres

        double x_1 = (r + alt_1) * Math.sin(lon_1) * Math.cos(lat_1);
        double y_1 = (r + alt_1) * Math.sin(lon_1) * Math.sin(lat_1);
        double z_1 = (r + alt_1) * Math.cos(lon_1);

        double x_2 = (r + alt_2) * Math.sin(lon_2) * Math.cos(lat_2);
        double y_2 = (r + alt_2) * Math.sin(lon_2) * Math.sin(lat_2);
        double z_2 = (r + alt_2) * Math.cos(lon_2);

        double dist = Math.sqrt((x_2 - x_1) * (x_2 - x_1) + (y_2 - y_1) *
                (y_2 - y_1) + (alt_2-alt_1) * (alt_2 - alt_1));
        return dist;
    }

    public static LinkedHashMap<Unit, Double> sortByValue(Map<Unit, Double> distanceToUnits) {
        List<Map.Entry<Unit, Double>> entries = new ArrayList<>(distanceToUnits.entrySet());

        entries.sort(Map.Entry.comparingByValue());

        LinkedHashMap<Unit, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Unit, Double> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
