package com.lgx.demo.service;
import com.lgx.demo.model.Rent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RentServiceImpl implements RentService {

    private final static Map<Integer, Rent> rentDao = new HashMap<>();
    private static int serialId = 1;

    @Override
    public int rentCar(int userId, int carId) {
        rentDao.put(serialId, new Rent(serialId, carId, userId, false));
        serialId++;
        return serialId - 1;
    }

    @Override
    public int returnCar(int rentId) {
        if(rentDao.containsKey(rentId)){
            rentDao.get(rentId).setFinished(true);
            return rentId;
        }
        return -1;
    }

    @Override
    public List<Rent> getRentList() {
        return new ArrayList<>(rentDao.values());
    }
}
