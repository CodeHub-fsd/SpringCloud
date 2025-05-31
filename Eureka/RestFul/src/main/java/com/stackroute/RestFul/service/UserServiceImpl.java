package com.stackroute.RestFul.service;

import com.stackroute.RestFul.model.User;
import com.stackroute.RestFul.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    //Constructor based autowiring
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userDetails=userRepository.findAll();
        return userDetails;
    }

    @Override
    public Optional<User> getById(Integer id) {
        Optional<User> userById = userRepository.findById(id);
        return userById;
    }

    @Override
    public String updateById(Integer id, Integer telePhone) {
        Optional<User> userById = userRepository.findById(id);
        if(userById.isPresent()) {
            User user = userById.get();
            user.setTelephoneNumber(telePhone);
            userRepository.save(user);
            return "user updated successfully";
        } else {
            return "User with id:"+id+" doesn't exist in system";
        }
    }

    @Override
    public void updateByIdPut(User user) {
        userRepository.save(user);
    }
}
