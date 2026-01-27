package com.jamillyferreira.mongoapi.repository;

import com.jamillyferreira.mongoapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
