package com.lgx.demo.model;


public class Car {
    private int id;
    private String model;
    private boolean available;

    public Car() {
    }

    public Car(int id, String model, boolean available) {
        this.id = id;
        this.model = model;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Car)) return false;
        Car c = (Car)o;
        return c.id == this.id;
    }
}
