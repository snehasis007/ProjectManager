package com.cts.projectmanager.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.model.Task;
@Repository
public interface TaskRepository extends MongoRepository<Task,String>{
	public List<Task> findByProjectID(String projectID);
}
