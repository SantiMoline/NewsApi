package com.smdevelopment.egg_news.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smdevelopment.egg_news.entitiy.User;
import com.smdevelopment.egg_news.exception.EntityNotFoundException;
import com.smdevelopment.egg_news.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Override
    public User modifyActiveStatus(String username) {
        User user = getUser(username);
        user.setActive(user.isActive() ? false : true);
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return unwrapUser(user, 404L); //Se pone cualquier id para poder usar el método unwrapp sin sobrecargarlo.
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        user.setRegistrationDate(LocalDate.now());
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        User updated = copyFromUpdate(user, id);
        return userRepository.save(updated);
    }
    
    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }

    protected User copyFromUpdate(User updated, Long id) {
        User user = getUser(id);
        user.setPassword(updated.getPassword());
        user.setUsername(updated.getUsername());
        return user;
    }
}
