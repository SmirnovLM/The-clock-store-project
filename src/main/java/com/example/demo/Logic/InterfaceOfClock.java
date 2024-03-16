package com.example.demo.Logic;

public interface InterfaceOfClock {
    String getName();
    int getCost();
    void GetStartTime(TimeType vt, int value) throws ThrowException;
    void PlusTime(TimeType vt, int value) throws ThrowException;
}

