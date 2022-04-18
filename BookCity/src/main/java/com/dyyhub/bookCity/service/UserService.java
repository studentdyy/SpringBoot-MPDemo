package com.dyyhub.bookCity.service;

import com.dyyhub.bookCity.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User getByUserId();
}
