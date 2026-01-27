package com.jamillyferreira.mongoapi.controller;

import com.jamillyferreira.mongoapi.dto.UserDTO;
import com.jamillyferreira.mongoapi.model.User;
import com.jamillyferreira.mongoapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


    // Metodo p/ converter obj para DTO
    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getName(), user.getEmail());
    }

    private User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }


}
