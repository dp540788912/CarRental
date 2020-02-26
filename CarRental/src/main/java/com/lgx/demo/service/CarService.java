package com.lgx.demo.service;

import com.lgx.demo.model.Car;

import java.util.List;

public interface CarService {
    public int rentCarById(int id);
    public boolean returnCar(int id);
    public List<Car> findModelAvailable(String model);
    public List<Car> availableCarList();
    public int addCar(Car car);
    public boolean isCarAvailable(int carId);
    public List<Car> allCars();
}
