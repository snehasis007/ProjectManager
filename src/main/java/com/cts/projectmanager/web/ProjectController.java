package com.cts.projectmanager.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.projectmanager.exception.PmException;
import com.cts.projectmanager.model.ParentTask;
import com.cts.projectmanager.model.Project;
import com.cts.projectmanager.model.ServiceResult;
import com.cts.projectmanager.model.Task;
import com.cts.projectmanager.model.User;
import com.cts.projectmanager.service.IProjectManager;




@RestController
@RequestMapping(value = "services/projectservice")
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	private IProjectManager manager;
	@Autowired
	public ProjectController(IProjectManager manager) {
		this.manager=manager;
	}
	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public String ping(){
		 return "Hi! \n #######ProjectManeger Service Working##########";
	}
	
	@RequestMapping(value = "getalltasks", method = RequestMethod.GET)
	public ResponseEntity<ServiceResult<Task>> getAllTasks(){
		logger.info("inside getAllTasks");
		ServiceResult<Task> result=new ServiceResult<Task>();
		try {
			List<Task> tasks=manager.getAllTasks();
			result.setDataList(tasks);
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "getallparenttasks", method = RequestMethod.GET)
	public ResponseEntity<ServiceResult<ParentTask>> getAllParentTasks(){
		logger.info("inside getallparenttasks");
		ServiceResult<ParentTask> result=new ServiceResult<ParentTask>();
		try {
			List<ParentTask> tasks=manager.getAllParentTasks();
			result.setDataList(tasks);
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "getallusers", method = RequestMethod.GET)
	public ResponseEntity<ServiceResult<User>> getAllUsers(){
		logger.info("inside getAllUsers");
		ServiceResult<User> result=new ServiceResult<User>();
		try {
			List<User> users=manager.getAllUsers();
			result.setDataList(users);
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "getallprojects", method = RequestMethod.GET)
	public ResponseEntity<ServiceResult<Project>> getAllProjects(){
		logger.info("inside getallprojects");
		ServiceResult<Project> result=new ServiceResult<Project>();
		try {
			List<Project> projects=manager.getAllProjects();
			result.setDataList(projects);
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "savetask",method = RequestMethod.POST)
	public ResponseEntity<ServiceResult<String>> saveOrUpdateTask(@RequestBody @Valid Task task){
		logger.info("inside saveOrUpdateTask");
		ServiceResult<String> result=new ServiceResult<String>();
		try {

			manager.createOrUpdateTask(task);
			result.setData("success");
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "saveuser",method = RequestMethod.POST)
	public ResponseEntity<ServiceResult<String>> saveOrUpdateUser(@RequestBody @Valid User user){
		logger.info("inside saveOrUpdateUser");
		ServiceResult<String> result=new ServiceResult<String>();
		try {

			manager.createOrUpdateUser(user);
			result.setData("success");
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "saveproject",method = RequestMethod.POST)
	public ResponseEntity<ServiceResult<String>> saveOrUpdateProject(@RequestBody @Valid Project project){
		logger.info("inside saveOrUpdateProject");
		ServiceResult<String> result=new ServiceResult<String>();
		try {

			manager.createOrUpdateProject(project);
			result.setData("success");
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	@RequestMapping(value = "removeuser",method = RequestMethod.POST)
	public ResponseEntity<ServiceResult<String>> deleteUser(@RequestBody @Valid User user){
		logger.info("inside deleteUser");
		ServiceResult<String> result=new ServiceResult<String>();
		try {

			manager.deleteUser(user.getId());
			result.setData("success");
			result.setSuccess(true);
		}catch(PmException e) {
			result.setSuccess(false);
			result.setError(e.getError());
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
