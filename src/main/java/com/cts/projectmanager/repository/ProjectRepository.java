package com.cts.projectmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanager.model.Project;
@Repository
public interface ProjectRepository extends MongoRepository<Project,String> {

}
