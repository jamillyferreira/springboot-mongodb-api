package com.jamillyferreira.mongoapi.service;

import com.jamillyferreira.mongoapi.exceptions.ResourceNotFoundException;
import com.jamillyferreira.mongoapi.model.User;
import com.jamillyferreira.mongoapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Usuário não encontrado com id: " + id));
    }
}
