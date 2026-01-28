package com.jamillyferreira.mongoapi.service;

import com.jamillyferreira.mongoapi.exceptions.EmailAlreadyExistsException;
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

    public User create(User user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        return repository.insert(user);
    }

    public User update(String id, User userUpdateData) {
        User existingUser = findById(id);

        if (!existingUser.getEmail().equals(userUpdateData.getEmail()) &&
                repository.existsByEmail(userUpdateData.getEmail())) {
            throw new EmailAlreadyExistsException(userUpdateData.getEmail());
        }
        existingUser.setName(userUpdateData.getName());
        existingUser.setEmail(userUpdateData.getEmail());
        return repository.save(existingUser);
    }

    public void delete(String id) {
        User user = findById(id);
        repository.delete(user);
    }

}
