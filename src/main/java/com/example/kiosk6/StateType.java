package com.example.kiosk6;

public enum StateType {
    BREAK("Break"),
    CONTINUE("Continue"),
    CLEAR("Clear"),
    ORDER("Order");

    private String state;

    StateType(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
