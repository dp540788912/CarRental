package com.lgx.demo.model;

import org.springframework.stereotype.Component;

public class Rent {
    private int rentID;
    private int carID;
    private int userID;
    private boolean finished;

    public Rent() {
    }

    public Rent(int rentID, int carID, int userID, boolean finished) {
        this.rentID = rentID;
        this.carID = carID;
        this.userID = userID;
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
