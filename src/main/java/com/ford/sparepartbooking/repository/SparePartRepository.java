package com.ford.sparepartbooking.repository;

import com.ford.sparepartbooking.entity.SparePart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository extends MongoRepository<SparePart, String> {
}