package com.jamillyferreira.mongoapi.repository;

import com.jamillyferreira.mongoapi.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
