package com.lgx.demo.service;
import com.lgx.demo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{
    private static List<User> userDao = new LinkedList<>();

    static {
        userDao.add(new User(1, "user1"));
        userDao.add(new User(2, "user2"));
        userDao.add(new User(3, "user3"));
        userDao.add(new User(4, "user4"));
        userDao.add(new User(5, "user5"));
    }

    @Override
    public boolean userExists(int id){
        for(User u: userDao){
            if(u.getId() == id)return true;
        }
        return false;
    }

    @Override
    public List<User> listUser() {
        return userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(User user) {
        for(User u: userDao){
            if(user.getId() == u.getId()){
                userDao.remove(u);
                break;
            }
        }
    }

}
