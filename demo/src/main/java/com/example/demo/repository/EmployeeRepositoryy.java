package com.example.demo.repository;

import com.example.demo.model.EmployeeModel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryy extends MongoRepository<EmployeeModel, String> {
}
