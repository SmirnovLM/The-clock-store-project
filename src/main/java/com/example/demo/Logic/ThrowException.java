package com.example.demo.Logic;

public class ThrowException extends Exception{
    private int i = 0;
    public ThrowException(int i, String message) {
        super(message);
        this.i = i;
    }
    @Override
    public String toString() {
        return "ThrowException{" + "i=" + i + "}:" + this.getMessage() +"\n";
    }
}
