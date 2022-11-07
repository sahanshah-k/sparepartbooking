package com.ford.sparepartbooking.repository;

import com.ford.sparepartbooking.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUsername(String username);
}