package com.battleshipgame.model;

/**
 * Created by MohamedOsman on 2017-10-25.
 */
public interface Subject {

    void  addObserver(Observer o);
    void removeObserver(Observer o);
    void  notifyAllObservers();



}
