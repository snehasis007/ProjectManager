package com.cts.projectmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.model.User;
@Repository
public interface UserRepository extends MongoRepository<User,String>{

}
