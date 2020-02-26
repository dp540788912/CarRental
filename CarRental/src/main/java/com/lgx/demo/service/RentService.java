package com.lgx.demo.service;

import com.lgx.demo.model.Rent;

import java.util.List;

public interface RentService {
    public int rentCar(int userId, int carId);
    public int returnCar(int rentId);
    public List<Rent> getRentList();
}
