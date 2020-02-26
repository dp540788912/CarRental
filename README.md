# CarRental

# get user lists
```
url: /user
method: get
req:
   
rsp:
    List of users
```

# get cars available for renting
```
url: /car
method: get
req:
   
rsp:
    List of available cars
```

# get available cars filtered by given model
```
url: /car/{model}
method: get
req:
   
rsp:
    list of Cars
```

# rent a car by giving userId and CarId
```
url: /car/rent/{userId}/{cardId}
method: get
req:
   
rsp:
    Result, format is like:
    {
        "result": true
        "msg": "You have rent the car, your tracking rent id is: "
    }
```

# return a car by giving rentId
```
url: "/car/return/{rentId}"
method: get
req:
   
rsp:
    Result, format is like:
    {
        "result": true
        "msg": "You have returned the car"
    }
```
# get the rent history, including finished records

```
url: /rent/history
method: get
req:
   
rsp:
    list of Rent
```
