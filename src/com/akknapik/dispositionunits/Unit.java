package com.akknapik.dispositionunits;

public class Unit {
    private String name;
    private Position position;
    private static final int numberOfFireTrucks = 5;
    private int fireTrucksInUnit;

    public Unit(String name, Position position, int fireTrucksInUnit) {
        this.name = name;
        this.position = position;
        this.fireTrucksInUnit = fireTrucksInUnit;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", fireTrucksInUnit=" + fireTrucksInUnit +
                '}';
    }
}
