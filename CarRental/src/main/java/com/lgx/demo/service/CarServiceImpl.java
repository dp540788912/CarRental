package com.lgx.demo.service;
import com.lgx.demo.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarServiceImpl implements CarService {

    private final static Map<Integer, Car> carDao = new HashMap<>();

    static {
        carDao.put(1, new Car(1, "ToyotaCamry", true));
        carDao.put(2, new Car(2, "ToyotaCamry", true));
        carDao.put(3, new Car(3, "BMW650", true));
        carDao.put(4, new Car(4, "BMW650", true));
    }

    @Override
    public int rentCarById(int id) {
        if(carDao.containsKey(id)){
            carDao.get(id).setAvailable(false);
            return id;
        }
        // -1 means failed (no id available)
        return -1;
    }

    @Override
    public boolean returnCar(int id) {
        if(carDao.containsKey(id)){
            carDao.get(id).setAvailable(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Car> findModelAvailable(String model) {
        List<Car> availableCarList = new ArrayList<>();
        for(Car c: carDao.values()){
            if(c.isAvailable() && c.getModel().equals(model)){
                availableCarList.add(c);
            }
        }
        return availableCarList;
    }

    @Override
    public List<Car> availableCarList() {
        List<Car> list = new ArrayList<>();
        for(Car c: carDao.values()){
            if(c.isAvailable()) list.add(c);
        }
        return list;
    }

    @Override
    public int addCar(Car car) {
        if(carDao.containsKey(car.getId())){
            return -1;
        }
        carDao.put(car.getId(), car);
        return car.getId();
    }

    @Override
    public boolean isCarAvailable(int carId){
        return carDao.containsKey(carId) && carDao.get(carId).isAvailable();
    }

    @Override
    public List<Car> allCars(){
        return new ArrayList<>(carDao.values());
    }
}
