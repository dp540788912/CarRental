package com.lgx.demo.service;
import com.lgx.demo.model.User;
import java.util.List;

public interface UserService {
    public List<User> listUser();
    public void add(User user);
    public void delete(User user);
    public boolean userExists(int id);
}
