package com.cts.projectmanager.service;

import java.util.List;

import com.cts.projectmanager.exception.PmException;
import com.cts.projectmanager.model.ParentTask;
import com.cts.projectmanager.model.Project;
import com.cts.projectmanager.model.Task;
import com.cts.projectmanager.model.User;

public interface IProjectManager {
	void createOrUpdateTask(Task tk) throws PmException;
	void createOrUpdateProject(Project p)throws PmException;
	void createOrUpdateUser(User u)throws PmException;
	List<Task> getAllTasks()throws PmException;
	//void deleteTask(String id)throws PmException;
	void deleteUser(String id)throws PmException;
	List<ParentTask> getAllParentTasks()throws PmException;
	List<Project> getAllProjects()throws PmException;
	List<User> getAllUsers()throws PmException;
}
