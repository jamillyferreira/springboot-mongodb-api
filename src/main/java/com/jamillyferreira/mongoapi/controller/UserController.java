package com.jamillyferreira.mongoapi.controller;

import com.jamillyferreira.mongoapi.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Silva", "mariasilva@gmail.com");
        User alex = new User("2", "Alex Green", "alexgreen@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(List.of(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
