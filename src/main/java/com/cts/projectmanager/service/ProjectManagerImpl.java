package com.cts.projectmanager.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.projectmanager.exception.PmException;
import com.cts.projectmanager.model.ParentTask;
import com.cts.projectmanager.model.Project;
import com.cts.projectmanager.model.Task;
import com.cts.projectmanager.model.User;
import com.cts.projectmanager.repository.ParentTaskRepository;
import com.cts.projectmanager.repository.ProjectRepository;
import com.cts.projectmanager.repository.TaskRepository;
import com.cts.projectmanager.repository.UserRepository;

@Service
public class ProjectManagerImpl implements IProjectManager {
	private static final Logger logger = LoggerFactory.getLogger(ProjectManagerImpl.class);
	private ParentTaskRepository parentRepo;
	private ProjectRepository projectRepo;
	private UserRepository userRepo;
	private TaskRepository taskRepo;

	@Autowired
	public ProjectManagerImpl(ParentTaskRepository parentRepo, ProjectRepository projectRepo, UserRepository userRepo,
			TaskRepository taskRepo) {
		super();
		this.parentRepo = parentRepo;
		this.projectRepo = projectRepo;
		this.userRepo = userRepo;
		this.taskRepo = taskRepo;
	}

	@Override
	public void createOrUpdateTask(Task tk) throws PmException {
		try {
			if (tk.getProject() != null) {
				tk.setProjectID(tk.getProject().getId());
				

				if (tk.getIsParent() != null && tk.getIsParent().equalsIgnoreCase("Y")) {
					parentRepo.save(tk.getpTask());
					tk.setpTask(new ParentTask());
				}
				taskRepo.save(tk);

				List<Task> relatedtks = taskRepo.findByProjectID(tk.getProjectID());
				if (relatedtks != null && relatedtks.size() > 0) {
					Project p = tk.getProject();
					p.setNoOfTask(relatedtks.size());
					List<Task> comptasks = relatedtks.stream()
							.filter(task -> "Y".equalsIgnoreCase(task.getIsTaskCompleted()))
							.collect(Collectors.toList());
					if (comptasks != null) {
						p.setNoOfTaskCompleted(comptasks.size());
					} else {
						p.setNoOfTaskCompleted(0);
					}
					projectRepo.save(p);
				}
			}

			logger.debug("task saved" + tk);
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}

	}

	@Override
	public void createOrUpdateProject(Project p) throws PmException {
		try {
			projectRepo.save(p);
			logger.debug("project saved" + p);
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}

	}

	@Override
	public void createOrUpdateUser(User u) throws PmException {
		try {
			userRepo.save(u);
			logger.debug("user  saved" + u);
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}

	}

	@Override
	public List<Task> getAllTasks() throws PmException {
		try {
			List<Task> alltasks = taskRepo.findAll();
			return alltasks;
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}
	}

	@Override
	public void deleteUser(String id) throws PmException {
		try {
			userRepo.deleteById(id);
			logger.debug("user  deleted" + id);
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}

	}

	@Override
	public List<ParentTask> getAllParentTasks() throws PmException {
		try {
			List<ParentTask> alltasks = parentRepo.findAll();
			return alltasks;
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}
	}

	@Override
	public List<Project> getAllProjects() throws PmException {
		try {
			List<Project> all = projectRepo.findAll();
			return all;
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}
	}

	@Override
	public List<User> getAllUsers() throws PmException {
		try {
			List<User> all = userRepo.findAll();
			return all;
		} catch (Exception e) {
			PmException te = new PmException("fail", e);
			throw te;
		}
	}

}
