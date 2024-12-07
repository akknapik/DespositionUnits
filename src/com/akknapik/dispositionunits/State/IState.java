package com.akknapik.dispositionunits.State;

import com.akknapik.dispositionunits.Incident;

public interface IState {
    void dispatch(Incident incident);
    void returnToUnit();
    boolean isAvailable();
}
