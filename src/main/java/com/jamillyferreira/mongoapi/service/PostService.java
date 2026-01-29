package com.jamillyferreira.mongoapi.service;

import com.jamillyferreira.mongoapi.exceptions.ResourceNotFoundException;
import com.jamillyferreira.mongoapi.model.Post;
import com.jamillyferreira.mongoapi.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Objeto não encontrado com id: " + id));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }


}
