package com.lgx.demo.controller;

import com.lgx.demo.model.Car;
import com.lgx.demo.model.Rent;
import com.lgx.demo.model.Result;
import com.lgx.demo.model.User;
import com.lgx.demo.service.CarService;
import com.lgx.demo.service.RentService;
import com.lgx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    RentService rentService;
    @Autowired
    CarService carService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.listUser();
    }

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public List<Car> getAvailableCars(){
        return carService.availableCarList();
    }

    @RequestMapping(value = "/car/{model}", method = RequestMethod.GET)
    public List<Car> findCarByModel(@PathVariable("model")String model){
        return carService.findModelAvailable(model);
    }

    @RequestMapping(value = "/car/rent/{userId}/{cardId}", method = RequestMethod.GET)
    public Result rentCar(@PathVariable("userId")int userId, @PathVariable("cardId")int carId){
        if(userService.userExists(userId) && carService.isCarAvailable(carId)){
            int rentId = rentService.rentCar(userId, carId);
            carService.rentCarById(carId);
            return new Result(true, "You have rent the car, your tracking rent id is: " + rentId);
        }
        return new Result(false, "Renting car failed");
    }

    @RequestMapping(value = "/car/return/{rentId}", method = RequestMethod.GET)
    public Result returnCar(@PathVariable("rentId")int rentId){
        int id = rentService.returnCar(rentId);
        if(id == -1){
            return new Result(false, "Failed to return");
        }
        return new Result(true, "You have return the car successfully");
    }

    @RequestMapping(value = "/rent/history", method = RequestMethod.GET)
    public List<Rent> findCarByModel(){
        return rentService.getRentList();
    }

}
