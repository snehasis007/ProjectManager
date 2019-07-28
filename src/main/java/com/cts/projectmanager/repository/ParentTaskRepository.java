package com.cts.projectmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.model.ParentTask;
@Repository
public interface ParentTaskRepository extends MongoRepository<ParentTask,String>{

}
