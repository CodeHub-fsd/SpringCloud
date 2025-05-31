package com.stackroute.RestFul.service;

import com.stackroute.RestFul.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public void saveUser(User user);

    public List<User> getAllUsers();

    public Optional<User> getById(Integer id);

    public String updateById(Integer id, Integer telePhone);

    public void updateByIdPut(User user);
}
