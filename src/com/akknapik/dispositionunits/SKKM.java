package com.akknapik.dispositionunits;

import java.util.List;

public class SKKM {
    private List<Unit> allUnits;

    public SKKM() {
    }

    public void registerObserver(List<Unit> units) {
        this.allUnits = units;
    }

}
