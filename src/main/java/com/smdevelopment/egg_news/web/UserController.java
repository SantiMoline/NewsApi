package com.smdevelopment.egg_news.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smdevelopment.egg_news.entitiy.User;
import com.smdevelopment.egg_news.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    
    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        return new ResponseEntity<String>(userService.getUser(id).getUsername(),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }

    @PutMapping("/{username}/activation")
    public ResponseEntity<String> changeStatus(@PathVariable String username) {
        String rta = userService.modifyActiveStatus(username).isActive() ? "Active" : "Inactive";
        return new ResponseEntity<String>(rta, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
