package com.pribas.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pribas.demo.models.AllData;
import com.pribas.demo.models.Data;

public interface RepositoryDbMongo extends MongoRepository<AllData, String> {

}
