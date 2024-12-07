package com.akknapik.dispositionunits.State;

public interface IState {
    void dispatch();
    void returnToUnit();
    boolean isAvailable();
}
