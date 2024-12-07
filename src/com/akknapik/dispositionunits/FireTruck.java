package com.akknapik.dispositionunits;

import com.akknapik.dispositionunits.State.IState;
import com.akknapik.dispositionunits.State.InUnitState;

import java.util.ArrayList;
import java.util.List;

public class FireTruck {
    private IState state;
    private String name;

    private FireTruck(String name) {
        this.state = new InUnitState(this);
        this.name = name;
    }

    public static List<FireTruck> createFireTrucks(String unitName, int numberOfFireTrucks) {
        List<FireTruck> fireTruckList = new ArrayList<>();
        for(int i = 1; i <= numberOfFireTrucks; i++) {
            fireTruckList.add(new FireTruck(unitName + i));
        }
        return fireTruckList;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return state.isAvailable();
    }

    public void dispatch(Incident incident) {
        state.dispatch(incident);
    }

    public void returnToUnit() {
        state.returnToUnit();
    }


}
