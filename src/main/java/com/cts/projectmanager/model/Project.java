package com.cts.projectmanager.model;

import java.util.List;

import org.springframework.data.annotation.Id;


public class Project extends PmBase{
	@Id
    private String id;
	private String project;
	private String startDate;
	private String endDate;
	private Integer priority;
	private User manager;
	private String isSuspended;
	private Integer noOfTask;
	private Integer noOfTaskCompleted;
	
	

	public Project() {
		
	}

	public Project(String project, String startDate, String endDate, Integer priority, User manager, String isSuspended,
			Integer noOfTask, Integer noOfTaskCompleted) {
		super();
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.manager = manager;
		this.isSuspended = isSuspended;
		this.noOfTask = noOfTask;
		this.noOfTaskCompleted = noOfTaskCompleted;
	}
	
	public Integer getNoOfTask() {
		return noOfTask;
	}

	public void setNoOfTask(Integer noOfTask) {
		this.noOfTask = noOfTask;
	}

	public Integer getNoOfTaskCompleted() {
		return noOfTaskCompleted;
	}

	public void setNoOfTaskCompleted(Integer noOfTaskCompleted) {
		this.noOfTaskCompleted = noOfTaskCompleted;
	}

	public String getIsSuspended() {
		return isSuspended;
	}
	public void setIsSuspended(String isSuspended) {
		this.isSuspended = isSuspended;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	
}
