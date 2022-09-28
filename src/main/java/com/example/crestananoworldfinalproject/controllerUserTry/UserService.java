package com.example.crestananoworldfinalproject.controllerUserTry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}