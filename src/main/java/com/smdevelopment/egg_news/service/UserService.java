package com.smdevelopment.egg_news.service;

import java.util.List;

import com.smdevelopment.egg_news.entitiy.User;


public interface UserService {
    User createUser(User user);
    List<User> getUsers();
    User getUser(Long id);
    User getUser(String username);
    User updateUser(User user, Long id);
    User modifyActiveStatus(String username);
}
