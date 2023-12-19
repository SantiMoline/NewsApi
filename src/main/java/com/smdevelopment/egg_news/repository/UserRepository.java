package com.smdevelopment.egg_news.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.smdevelopment.egg_news.entitiy.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
